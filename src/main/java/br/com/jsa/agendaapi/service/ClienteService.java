package br.com.jsa.agendaapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.exception.DadoInvalidoException;
import br.com.jsa.agendaapi.model.Cliente;
import br.com.jsa.agendaapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Iterable<Cliente> buscarClientePorNomeOuDataNascimento(String nome, Date dataNascimento) throws DadoInvalidoException {
		Iterable<Cliente> listaClientes = null;
		if(nome.length() == 0 && dataNascimento == null)
			throw new DadoInvalidoException("É obrigatório o preenchimento de pelo menos um campo");
		if(nome.length() > 0)
			listaClientes = clienteRepository.findByNomeContains(nome);
		else if(dataNascimento != null)
			listaClientes = clienteRepository.findByDataNascimento(dataNascimento);
		
		return listaClientes;	
	}
	

}
