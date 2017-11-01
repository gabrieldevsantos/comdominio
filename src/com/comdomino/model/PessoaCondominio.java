/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comdomino.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author luciano
 */
@Entity
public class PessoaCondominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
  

	private String dataInicio;
    
    private String dataFim;
    
    @ManyToOne(fetch = FetchType.EAGER)
  	@ForeignKey(name = "condominioid")
    private Condominio condominio = new Condominio();
    
    @ManyToOne(fetch = FetchType.EAGER)
  	@ForeignKey(name = "pessoaid")
    private Pessoa pessoa = new Pessoa();

    public PessoaCondominio() {
    }

    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaCondominio other = (PessoaCondominio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public String getDataInicio() {
        return dataInicio;
    }
    
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

   
   
}
