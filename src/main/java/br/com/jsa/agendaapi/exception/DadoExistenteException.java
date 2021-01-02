package br.com.jsa.agendaapi.exception;

public class DadoExistenteException extends Throwable {

	private static final long serialVersionUID = 1L;

	public DadoExistenteException(String nomeCampoExistente) {
		super(nomeCampoExistente + " já cadastrado na base de dados.");
	}
}
