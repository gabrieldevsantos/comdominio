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
public class LancamentoFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataLancamento;
    private String descricao;
    private Integer servicoPessoaServicoId;
    private Integer servicoPessoaPessoaId;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "servicoid")
    private Servico servico = new Servico();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "financeiroid")      
    private Financeiro financeiro = new Financeiro();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "lancamentoid")
    private Lancamento lancamento = new Lancamento();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "pessoaid")
    private Pessoa pessoa = new Pessoa();

    public LancamentoFinanceiro() {
    }

    public LancamentoFinanceiro(Long id) {
        this.id = id;
    }

    public LancamentoFinanceiro(Long id, String dataLancamento, String descricao) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getServicoPessoaServicoId() {
        return servicoPessoaServicoId;
    }

    public void setServicoPessoaServicoId(Integer servicoPessoaServicoId) {
        this.servicoPessoaServicoId = servicoPessoaServicoId;
    }

    public Integer getServicoPessoaPessoaId() {
        return servicoPessoaPessoaId;
    }

    public void setServicoPessoaPessoaId(Integer servicoPessoaPessoaId) {
        this.servicoPessoaPessoaId = servicoPessoaPessoaId;
    }

    public Servico getServicoId() {
        return servico;
    }

    public void setServicoId(Servico servicoId) {
        this.servico = servicoId;
    }

    public Financeiro getFinanceiroId() {
        return financeiro;
    }

    public void setFinanceiroId(Financeiro financeiroId) {
        this.financeiro = financeiroId;
    }

    public Lancamento getLancamentoId() {
        return lancamento;
    }

    public void setLancamentoId(Lancamento lancamentoId) {
        this.lancamento = lancamentoId;
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
        if (!(object instanceof LancamentoFinanceiro)) {
            return false;
        }
        LancamentoFinanceiro other = (LancamentoFinanceiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.LancamentoFinanceiro[ id=" + id + " ]";
    }
    
}
