package br.com.jsa.agendaapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.exception.DadoInvalidoException;
import br.com.jsa.agendaapi.model.Cliente;
import br.com.jsa.agendaapi.model.Contato;
import br.com.jsa.agendaapi.model.Telefone;
import br.com.jsa.agendaapi.repository.ClienteRepository;
import br.com.jsa.agendaapi.repository.ContatoRepository;
import br.com.jsa.agendaapi.repository.TelefoneRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public void salvar(Cliente cliente) {
		Contato contato = cliente.getContato();
		cliente.setContato(null);
		
		List<Telefone> telefone = contato.getTelefone();
		contato.setTelefone(new ArrayList<Telefone>());
		
		Cliente c = clienteRepository.save(cliente);
		
		contato.setPessoa(c);
		Contato co = contatoRepository.save(contato);
		
		telefone
			.stream()
			.forEach(t -> t.setContato(co));
		
		telefone
			.stream()
			.forEach(t -> telefoneRepository.save(t));
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
