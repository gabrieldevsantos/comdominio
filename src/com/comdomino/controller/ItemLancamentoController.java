package com.comdomino.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comdomino.dao.DaoImplementacao;
import com.comdomino.dao.DaoInterface;
import com.comdomino.model.ItemLancamento;
import com.comdomino.model.Lancamento;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

@Controller
@RequestMapping(value = "/itemlancamento")
public class ItemLancamentoController extends DaoImplementacao<ItemLancamento>
		implements DaoInterface<ItemLancamento> {
	
	public ItemLancamentoController(Class<ItemLancamento> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		ItemLancamento objeto = new Gson().fromJson(jsonPost,
				ItemLancamento.class);
		System.out.println(jsonPost);
		super.salvar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/postmany", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarLista(@RequestBody String jsonPost)
			throws Exception{
		List<ItemLancamento> list =  (ArrayList<ItemLancamento>)new Gson().fromJson(jsonPost,
                new TypeToken<ArrayList<ItemLancamento>>() {
                }.getType());
		
		for (ItemLancamento item : list) {
			System.out.println(item);
			super.salvar(item);
		}
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		ItemLancamento objeto = new Gson().fromJson(jsonPut, ItemLancamento.class);
		System.out.println(jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		ItemLancamento objeto = new Gson().fromJson(jsonPost,
				ItemLancamento.class);
		System.out.println(jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}
	/******************************
	 * EXEMPLO DE QUERY NATIVA
	 * ***************************/
	/*
	String sql = "SELECT * FROM freelancer where login = '"+objeto.getId()+"'";
	@SuppressWarnings("unchecked")
	List<Pessoa> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancer", Pessoa.class).list();
			
	//imprime lista de resultados
	for (Object item : results) {
		System.out.println(item.toString());
	}
	//verifica se encontrou resultados
	if(results.isEmpty()){
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}else{
		return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
	}	
	*/
	
	@CrossOrigin
	@RequestMapping(value = "lancamento/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscarPorLancamento(@PathVariable("id") String id)
			throws Exception {
		
		String sql = "SELECT * FROM itemlancamento where lancamento_id = '"+id+"'";
		@SuppressWarnings("unchecked")
		List<ItemLancamento> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancer", ItemLancamento.class).list();
		
		//imprime lista de resultados
		for (Object item : results) {
			System.out.println(item.toString());
		}
		//verifica se encontrou resultados
		if(!results.isEmpty()){
			String json = new Gson().toJson(results);
			return json;
		}else{
			return new Gson().toJson("[{}]");
		}	
		
		
		
	}

	@CrossOrigin
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		ItemLancamento objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(id)));
		return "";
	}
}









