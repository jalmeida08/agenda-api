package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity(name="atendimento")
public class Atendimento implements Serializable{
	
	private static final long serialVersionUID = 754262637058062883L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="valor_total")
	private double valorTotal;
	private float desconto;
	@Column(name="data_atendimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtendimento;
	@Column(name="data_agendamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgendamento;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="procedimento_id")
//	@JsonIgnore
	private List<Procedimento> procedimento = new ArrayList<Procedimento>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="pessoa_id")
//	@JsonIgnore
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();
	@ManyToOne
	private EstadoAtendimento estadoAtendimento;
	@Version
	private Integer versao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public List<Procedimento> getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(List<Procedimento> Procedimento) {
		this.procedimento = Procedimento;
	}
	public EstadoAtendimento getEstadoAtendimento() {
		return estadoAtendimento;
	}
	public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
		this.estadoAtendimento = estadoAtendimento;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
}
