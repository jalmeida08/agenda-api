package br.com.jsa.agendaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.model.Funcionario;
import br.com.jsa.agendaapi.repository.FuncionarioRepository;

@Service
public class PessoaService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public void salvar(Funcionario pessoa) {
		funcionarioRepository.save(pessoa);
	}
}
