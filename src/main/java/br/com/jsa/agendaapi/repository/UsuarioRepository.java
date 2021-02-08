package br.com.jsa.agendaapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.agendaapi.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    public Optional<Usuario> findByUsuario(String usuario);
    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findByChaveAtivacao(String chaveAtivacao);
}
