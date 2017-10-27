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
public class AgendamentoLazer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String inicio;
    private String fim;
    private String evento;
    private Boolean aprovacao;
    private String dataaprovacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "areadelazerid")
    private AreaLazer areaDeLazer = new AreaLazer();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "condominioid")
    private Condominio condominio = new Condominio();
    
    @ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "pessoaid")
    private Pessoa pessoa = new Pessoa();

    
    public AgendamentoLazer() {
    }

    public AgendamentoLazer(Long id) {
        this.id = id;
    }

    public AgendamentoLazer(Long id, String inicio, String fim, String evento) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public String getDataaprovacao() {
        return dataaprovacao;
    }

    public void setDataaprovacao(String dataaprovacao) {
        this.dataaprovacao = dataaprovacao;
    }

    public AreaLazer getAreaDeLazerId() {
        return areaDeLazer;
    }

    public void setAreaDeLazerId(AreaLazer areaDeLazerId) {
        this.areaDeLazer = areaDeLazerId;
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
        if (!(object instanceof AgendamentoLazer)) {
            return false;
        }
        AgendamentoLazer other = (AgendamentoLazer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comdomino.model.AgendamentoLazer[ id=" + id + " ]";
    }
    
}
