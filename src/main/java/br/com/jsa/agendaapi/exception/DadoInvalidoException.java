package br.com.jsa.agendaapi.exception;

public class DadoInvalidoException extends Throwable {

	private static final long serialVersionUID = 1L;

	public DadoInvalidoException(String erro) {
		super(erro);
	}
}
