/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comdomino.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
//import javax.validation.constraints.NotNull;

/**
 *
 * @author luciano
 */
@Embeddable
public class PessoaCondominioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    //@NotNull
    @Column(name = "pessoa_id")
    private int pessoaId;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "condominio_id")
    private int condominioId;

    public PessoaCondominioPK() {
    }

    public PessoaCondominioPK(int pessoaId, int condominioId) {
        this.pessoaId = pessoaId;
        this.condominioId = condominioId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(int condominioId) {
        this.condominioId = condominioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pessoaId;
        hash += (int) condominioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaCondominioPK)) {
            return false;
        }
        PessoaCondominioPK other = (PessoaCondominioPK) object;
        if (this.pessoaId != other.pessoaId) {
            return false;
        }
        if (this.condominioId != other.condominioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.PessoaCondominioPK[ pessoaId=" + pessoaId + ", condominioId=" + condominioId + " ]";
    }
    
}
