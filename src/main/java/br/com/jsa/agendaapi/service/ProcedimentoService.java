package br.com.jsa.agendaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.exception.DadoInexistenteException;
import br.com.jsa.agendaapi.model.Procedimento;
import br.com.jsa.agendaapi.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public void salvarProcedimento(Procedimento procedimento) {
		procedimentoRepository.save(procedimento);
	}
	
	public Iterable<Procedimento> listarProcedimento() {
		return procedimentoRepository.findAll();
	}
	
	public Procedimento buscarProcedimento(Long id) throws DadoInexistenteException {
		Optional<Procedimento> p  = procedimentoRepository.findById(id);
		if(!p.isPresent())
			throw new DadoInexistenteException("Procedimento", "");
		return p.get();
	}

}
