package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="estado_atendimento")
@JsonIdentityInfo(scope = EstadoAtendimento.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class EstadoAtendimento implements Serializable {
	
	private static final long serialVersionUID = -8002779279442346438L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(mappedBy="estadoAtendimento")
	private List<Atendimento>listaAtendimento = new ArrayList<Atendimento>();
	@Version
	private Integer versao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Atendimento> getListaAtendimento() {
		return listaAtendimento;
	}
	public void setListaAtendimento(List<Atendimento> listaAtendimento) {
		this.listaAtendimento = listaAtendimento;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	
}
