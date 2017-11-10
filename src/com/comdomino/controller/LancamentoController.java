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
import com.comdomino.model.ItemLancamento;
import com.comdomino.model.Lancamento;
import com.comdomino.dao.DaoInterface;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/lancamento")
public class LancamentoController extends DaoImplementacao<Lancamento>
		implements DaoInterface<Lancamento> {
	
	public LancamentoController(Class<Lancamento> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		Lancamento objeto = new Gson().fromJson(jsonPost,
				Lancamento.class);
		System.out.println(jsonPost);
		super.salvar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		Lancamento objeto = new Gson().fromJson(jsonPut, Lancamento.class);
		System.out.println(jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		Lancamento objeto = new Gson().fromJson(jsonPost,
				Lancamento.class);
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

	@CrossOrigin
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		Lancamento objeto = super.loadObjeto(Long.parseLong(id));
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
	
	@CrossOrigin
	@RequestMapping(value = "/last", method = RequestMethod.GET)
	@ResponseBody
	public String retornarUltimo()
			throws Exception {
		Lancamento objeto = super.lista().get(super.lista().size()-1);;
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/lastfive", method = RequestMethod.GET)
	@ResponseBody
	public String ultimosCinco()
			throws Exception {
		List<Lancamento> lastfive = new ArrayList<Lancamento>();
		List<Lancamento> list = new ArrayList<Lancamento>();
		list = super.lista();

		for(int i = (list.size()-1); i > (list.size()-6);i--){
			lastfive.add(list.get(i));
		}
		String json = new Gson().toJson(lastfive);
		System.out.println(json);
		return json;
	}

}










