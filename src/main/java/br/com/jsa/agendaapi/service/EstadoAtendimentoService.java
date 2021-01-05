package br.com.jsa.agendaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.model.EstadoAtendimento;
import br.com.jsa.agendaapi.repository.EstadoAtendimentoRepository;

@Service
public class EstadoAtendimentoService {
	
	@Autowired
	private EstadoAtendimentoRepository estadoAtendimentoRepository;
	
	public Iterable<EstadoAtendimento> listarEstadoAtendimento() {
		return estadoAtendimentoRepository.findAll();
	}
	

}
