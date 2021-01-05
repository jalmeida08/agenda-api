package br.com.jsa.agendaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.EstadoAtendimento;

@Repository
public interface EstadoAtendimentoRepository extends CrudRepository<EstadoAtendimento, Long>{

}
