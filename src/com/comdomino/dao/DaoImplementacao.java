package com.comdomino.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comdomino.hibernate.HibernateUtil;
/**
 * Implementação dos metodos padrões da interface de acesso ao banco e operações
 * @author alex
 * @param <T>
 */
@Transactional(noRollbackFor = Exception.class)
@Service
public abstract class DaoImplementacao<T> implements DaoInterface<T> {

	private Class<T> persistenceClass;

	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public DaoImplementacao(Class<T> persistenceClass) {
		super();
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void salvar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().save(objeto);
		 sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deletar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().delete(objeto);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void atualizar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().update(objeto);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void salvarOuAtualizar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(objeto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T merge(T objeto) throws Exception {
		 T t =  (T) sessionFactory.getCurrentSession().merge(objeto);
		 sessionFactory.getCurrentSession().flush();
		 return t;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista() throws Exception {
		Criteria criteria =sessionFactory.getCurrentSession().createCriteria(persistenceClass);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T loadObjeto(Long codigo) throws Exception { 
		return (T) sessionFactory.getCurrentSession().get(persistenceClass, codigo);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista(String campoBanco, String valorCampo) throws Exception {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.like(campoBanco, valorCampo));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista(String campoBanco, Long valorCampo) throws Exception {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.eq(campoBanco, valorCampo));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listaLikeExpression(String campoBanco, String valorCampo)
			throws Exception {
		 
		return getSessionFactory().
				getCurrentSession().
				createQuery(" select a from " + getPersistenceClass().getSimpleName() + " a where a." + campoBanco + " like'%" + valorCampo + "%'").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista(String ids) throws Exception {
		
		List<Long> longs = new ArrayList<Long>();
		
		String[] strings = ids.split(",");
		for (int i = 0 ; i < strings.length; i++){
			longs.add(Long.parseLong(strings[i]));
		}
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.in("id", longs));
		return criteria.list();
	}
	
	
	/**
	 * Retorna a lista de objetos de acordo com a pagina offset
	 * @param numeroPagina
	 * @return List<T> persistenceClass
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> consultaPaginada(String numeroPagina) throws Exception {
		int total_por_pagina = 6;
		if (numeroPagina == null || (numeroPagina != null && numeroPagina.trim().isEmpty())){
			numeroPagina = "0";
		}
		int offSet = (Integer.parseInt(numeroPagina) * total_por_pagina) - total_por_pagina; 
		
		if (offSet < 0){
			offSet = 0;
		}
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.setFirstResult(offSet);
		criteria.setMaxResults(total_por_pagina);
		criteria.addOrder(Order.asc("id"));

		return criteria.list();
	}

	/**
	 * Retorna a quantidade de paginas de registros
	 * @return int quantidadePagina
	 * @throws Exception
	 */
	public int quantidadePagina() throws Exception {
		String sql = "select count(1) as totalRegistros FROM " + getPersistenceClass().getSimpleName();
		int quantidadePagina = 1;
		double total_por_pagina = 6.0;
			SQLQuery find = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			Object resultSet = find.uniqueResult();
			if (resultSet != null) {
				double totalRegistros = Double.parseDouble(resultSet.toString());
				if (totalRegistros > total_por_pagina){
					
					double quantidadePaginaTemp = Float.parseFloat(""+(totalRegistros / total_por_pagina));

					if (!(quantidadePaginaTemp % 2 == 0)){
						quantidadePagina =   new Double(quantidadePaginaTemp).intValue() + 1;
					}
					else {
						quantidadePagina = new Double(quantidadePaginaTemp).intValue();
					}
				}else {
					quantidadePagina = 1;
				}
			}
		return quantidadePagina;
	}
}
