package br.com.jsa.agendaapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Cliente")
public class Cliente extends Pessoa{
	
	private static final long serialVersionUID = 528988411071999124L;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
