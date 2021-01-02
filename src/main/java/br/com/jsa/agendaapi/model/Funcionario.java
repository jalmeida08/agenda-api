package br.com.jsa.agendaapi.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Funcionario")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 7208594664678957776L;
	
}
