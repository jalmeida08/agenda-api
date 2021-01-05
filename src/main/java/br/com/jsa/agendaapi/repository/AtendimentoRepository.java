package br.com.jsa.agendaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Atendimento;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long>{
	
}