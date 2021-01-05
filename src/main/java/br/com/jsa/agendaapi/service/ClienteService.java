package br.com.jsa.agendaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.model.Cliente;
import br.com.jsa.agendaapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	

}
