package br.com.jsa.agendaapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.model.Atendimento;
import br.com.jsa.agendaapi.repository.AtendimentoRepository;
import br.com.jsa.agendaapi.repository.EstadoAtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private EstadoAtendimentoRepository estadoAtendimentoRepository;
	
	public void salvar(Atendimento atendimento) {
		atendimento.setEstadoAtendimento(estadoAtendimentoRepository.findById(1L).get());
		atendimentoRepository.save(atendimento);
		
	}
	
	public List<Atendimento> listaAtendimentoDia() {
		return atendimentoRepository.listaAtendimentoDiaSelecionado(new Date());
	}
	
	public List<Atendimento> listaAtendimentoDiaSelecionado(Date dataAgendamento) {
		return atendimentoRepository.listaAtendimentoDiaSelecionado(dataAgendamento);
	}
}
