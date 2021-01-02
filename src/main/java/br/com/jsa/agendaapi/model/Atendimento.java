package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="atendimento")
@JsonIdentityInfo(scope = Atendimento.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Atendimento implements Serializable{
	
	private static final long serialVersionUID = 754262637058062883L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="valor_total")
	private double valorTotal;
	private float desconto;
	@Column(name="data_atendimento")
	private Date dataAtendimento;
	@Column(name="data_agendamento")
	private Date dataAgendamento;
	@ManyToMany
	@JoinColumn(name="procedimento_id")
	private List<Procedimento> procedimento;
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
	
}
