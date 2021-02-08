package br.com.jsa.agendaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Contato;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Integer>{

}
