package br.com.jsa.agendaapi.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public Iterable<Cliente> findByNomeContains(String nome);
	public Iterable<Cliente> findByDataNascimento(Date dataNascimento);

}
