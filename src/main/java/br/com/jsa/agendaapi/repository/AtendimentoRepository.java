package br.com.jsa.agendaapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Atendimento;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long>{
	
	@Query(value="FROM atendimento WHERE DATE (data_agendamento) = ?1 ORDER BY data_agendamento")
//	@Query(value="FROM atendimento a INNER JOIN atendimento_pessoa ap ON ap.atendimento_id = a.id INNER JOIN pessoa p ON ap.pessoa_id = p.id INNER JOIN atendimento_procedimento atap ON atap.atendimento_id = a.id INNER JOIN procedimento pro ON pro.id = atap.procedimento_id WHERE DATE (data_agendamento) = ?1 ORDER BY data_agendamento")
	public List<Atendimento> listaAtendimentoDiaSelecionado(Date data);
	public List<Atendimento> findAllByDataAgendamento(Date data);
	
	
}