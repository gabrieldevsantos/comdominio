package com.comdomino.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comdomino.dao.DaoImplementacao;
import com.comdomino.dao.DaoInterface;
import com.comdomino.model.Unidade;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/unidade")
public class UnidadeController extends DaoImplementacao<Unidade>
		implements DaoInterface<Unidade> {
	
	public UnidadeController(Class<Unidade> persistenceClass) {
		super(persistenceClass);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		Unidade objeto = new Gson().fromJson(jsonPost,
				Unidade.class);
		System.out.println(jsonPost);
		super.salvar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		Unidade objeto = new Gson().fromJson(jsonPut, Unidade.class);
		System.out.println(jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		Unidade objeto = new Gson().fromJson(jsonPost,
				Unidade.class);
		System.out.println(jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}

	
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		Unidade objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(id)));
		return "";
	}

}








