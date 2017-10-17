package com.comdomino.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface destinada ao metodos padrão de operações no banco
 * @author alex
 * @param <T>
 */
@Transactional(noRollbackFor = Exception.class)
@Service
public interface DaoInterface<T> {

	void salvar (T objeto) throws Exception;
	
	void deletar (T objeto) throws Exception;
	
	void atualizar (T objeto) throws Exception;
	
	void salvarOuAtualizar (T objeto) throws Exception;
	
	T merge(T objeto) throws Exception;
	
	List<T> lista() throws Exception;
	
	List<T> lista(String ids) throws Exception;
	
	List<T> lista(String campoBanco, String valorCampo) throws Exception;
	
	 List<T> lista(String campoBanco, Long valorCampo) throws Exception;
	
	List<T> listaLikeExpression(String campoBanco, String valorCampo) throws Exception;
	
	T loadObjeto(Long codigo) throws Exception;
	
	int quantidadePagina() throws Exception;
	
	List<T> consultaPaginada(String numeroPagina) throws Exception;
	
}
