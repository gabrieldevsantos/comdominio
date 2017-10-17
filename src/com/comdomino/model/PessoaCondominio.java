/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comdomino.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luciano
 */
@Entity
public class PessoaCondominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PessoaCondominioPK pessoaCondominioPK;
    
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    
    @JoinColumn(name = "condominioid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Condominio condominio;
    
    @JoinColumn(name = "pessoaid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public PessoaCondominio() {
    }

    public PessoaCondominio(PessoaCondominioPK pessoaCondominioPK) {
        this.pessoaCondominioPK = pessoaCondominioPK;
    }

    public PessoaCondominio(int pessoaId, int condominioId) {
        this.pessoaCondominioPK = new PessoaCondominioPK(pessoaId, condominioId);
    }

    public PessoaCondominioPK getPessoaCondominioPK() {
        return pessoaCondominioPK;
    }

    public void setPessoaCondominioPK(PessoaCondominioPK pessoaCondominioPK) {
        this.pessoaCondominioPK = pessoaCondominioPK;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaCondominioPK != null ? pessoaCondominioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaCondominio)) {
            return false;
        }
        PessoaCondominio other = (PessoaCondominio) object;
        if ((this.pessoaCondominioPK == null && other.pessoaCondominioPK != null) || (this.pessoaCondominioPK != null && !this.pessoaCondominioPK.equals(other.pessoaCondominioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.PessoaCondominio[ pessoaCondominioPK=" + pessoaCondominioPK + " ]";
    }
    
}
