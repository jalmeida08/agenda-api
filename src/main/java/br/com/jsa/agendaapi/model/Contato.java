package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "contato")
@JsonIdentityInfo(scope = Contato.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Contato implements Serializable {

	private static final long serialVersionUID = 3431851117994865547L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy="contato")
	private List<Telefone> telefone = new ArrayList<Telefone>();
	@OneToOne
	private Pessoa pessoa;
	@Version
	private Integer versao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
