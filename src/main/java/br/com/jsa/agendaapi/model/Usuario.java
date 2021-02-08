package br.com.jsa.agendaapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "usuario")
@JsonIdentityInfo(scope = Usuario.class, generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 7404897341218414223L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String usuario;
	private String senha;
	@OneToOne
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	private String email;
	@ManyToMany
	@JoinTable(name="acesso_usuario")
	@JoinColumn(name="acesso_id")
	private List<Acesso> acesso;
	@Transient
	private String token;
    @Column(name = "ultimo_login")
	private Date ultimoLogin;
    @Column(name="chave_ativacao")
	private String chaveAtivacao;
    private boolean ativo;
    @Version
    private Integer versao;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Acesso> getAcesso() {
		return acesso;
	}
	public void setAcesso(List<Acesso> acesso) {
		this.acesso = acesso;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getUltimoLogin() {
		return ultimoLogin;
	}
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
	public String getChaveAtivacao() {
		return chaveAtivacao;
	}
	public void setChaveAtivacao(String chaveAtivacao) {
		this.chaveAtivacao = chaveAtivacao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}
}
   