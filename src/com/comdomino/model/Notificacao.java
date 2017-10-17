/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comdomino.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author luciano
 */
@Entity
public class Notificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "condominioid")
    private Condominio condominio = new Condominio();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "pessoaid")
    private Pessoa pessoa = new Pessoa();

    public Notificacao() {
    }

    public Notificacao(Long id) {
        this.id = id;
    }

    public Notificacao(Long id, String titulo, String descricao, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Condominio getCondominioId() {
        return condominio;
    }

    public void setCondominioId(Condominio condominioId) {
        this.condominio = condominioId;
    }

    public Pessoa getPessoaId() {
        return pessoa;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoa = pessoaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacao)) {
            return false;
        }
        Notificacao other = (Notificacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.Notificacao[ id=" + id + " ]";
    }
    
}
