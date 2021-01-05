package br.com.jsa.agendaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.model.Atendimento;
import br.com.jsa.agendaapi.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public void salvar(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
	}
	
}
