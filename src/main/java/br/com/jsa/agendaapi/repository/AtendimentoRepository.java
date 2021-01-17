package br.com.jsa.agendaapi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Atendimento;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long>{
	
	@Query(value="FROM atendimento WHERE data_atendimento = ?1")
	public Iterable<Atendimento> listaAtendimentoDia(Date data);
	
	
}