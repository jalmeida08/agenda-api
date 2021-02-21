package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "pessoa")
@JsonIdentityInfo(scope = Pessoa.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", length=10, discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = -1296401918052356656L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private String nome;
	@OneToOne(mappedBy="pessoa")
    @JoinColumn(name="usuario_id")
	private Usuario usuario;
	@OneToOne(mappedBy="pessoa")
	private Contato contato;
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="pessoa")
	@JsonIgnore
	private List<Atendimento> atendimento = new ArrayList<Atendimento>();
	@Column(insertable=false, updatable=false)
	private String dtype;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public List<Atendimento> getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}
}
