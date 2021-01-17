package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="procedimento")
@JsonIdentityInfo(scope = Procedimento.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Procedimento implements Serializable{

	private static final long serialVersionUID = -1251250532614699457L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double valor;
	@Column(name="tempo_duracao_procedimento")
	private float tempoDuracaoProcedimento;
	@ManyToMany(mappedBy="procedimento")
	private List<Atendimento> atendimento = new ArrayList<Atendimento>();
	@Version
	private Integer versao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public float getTempoDuracaoProcedimento() {
		return tempoDuracaoProcedimento;
	}
	public void setTempoDuracaoProcedimento(float tempoDuracaoProcedimento) {
		this.tempoDuracaoProcedimento = tempoDuracaoProcedimento;
	}
	public List<Atendimento> getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	
}
