/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comdomino.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;
/**
 *
 * @author luciano
 */
@Entity
public class ItemLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    private Float valorUnit;

    private Float quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "lancamentoid")
    private Lancamento lancamento= new Lancamento();
    

    public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public ItemLancamento() {
    }

    public ItemLancamento(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Float valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
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
        if (!(object instanceof ItemLancamento)) {
            return false;
        }
        ItemLancamento other = (ItemLancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.ItemLancamento[ id=" + id + " ]";
    }
    
}
