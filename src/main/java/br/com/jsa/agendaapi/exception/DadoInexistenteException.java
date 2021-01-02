package br.com.jsa.agendaapi.exception;

public class DadoInexistenteException extends Throwable {

	private static final long serialVersionUID = 1L;

	public DadoInexistenteException(String nomeCampoExistente, String complementoMensagem) {
		super(nomeCampoExistente + " não localizado no sistema "+complementoMensagem);
	}
}
