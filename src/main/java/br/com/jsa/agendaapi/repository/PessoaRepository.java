package br.com.jsa.agendaapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.jsa.agendaapi.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
