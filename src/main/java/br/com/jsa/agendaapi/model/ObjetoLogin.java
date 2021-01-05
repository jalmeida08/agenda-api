package br.com.jsa.agendaapi.model;

import java.io.Serializable;

public class ObjetoLogin implements Serializable{

	private static final long serialVersionUID = 7497415071372041191L;
	
	private String emailUsuario;
	private String senha;
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
