package br.com.jsa.agendaapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.com.jsa.agendaapi.Util;
import br.com.jsa.agendaapi.config.JwtTokenUtil;
import br.com.jsa.agendaapi.exception.DadoExistenteException;
import br.com.jsa.agendaapi.exception.DadoInexistenteException;
import br.com.jsa.agendaapi.model.Funcionario;
import br.com.jsa.agendaapi.model.Pessoa;
import br.com.jsa.agendaapi.model.Usuario;
import br.com.jsa.agendaapi.repository.FuncionarioRepository;
import br.com.jsa.agendaapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
    @Autowired
    private MensageriaService mensageriaService;

    
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	 public void salvarNovoUsuarioFuncionario(Usuario usuario) throws DadoExistenteException, MessagingException {
		Optional<Usuario> u = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(u.isPresent())
			throw new DadoExistenteException("E-mail");
		
		Pessoa p = usuario.getPessoa();
		
		Funcionario f = new Funcionario();
		f.setNome(p.getNome());
		f.setUsuario(p.getUsuario());
		
		usuario.setPessoa(funcionarioRepository.save(f));
		usuarioRepository.save(usuario);
		gerarChaveAtivacaoUsuario(usuario);
	}


	private void gerarChaveAtivacaoUsuario(Usuario usuario) throws MessagingException {
		usuario.setChaveAtivacao(Util.criptografar(usuario.getId().toString()));
		usuarioRepository.save(usuario);
		mensageriaService.enviarEmailNovoUsuario(usuario.getEmail(), usuario.getPessoa().getNome(), usuario.getChaveAtivacao());
	}
    
    public UserDetails login(Usuario usuario) {
        Usuario findByUsuario = usuarioRepository.findByUsuario(usuario.getUsuario()).get();
        if(findByUsuario != null) {
            if(usuario.getUsuario().equals(findByUsuario.getUsuario()) && BCrypt.checkpw(usuario.getSenha(), findByUsuario.getSenha())) {
                return new User(findByUsuario.getUsuario(), usuario.getSenha(), new ArrayList<>());
            } else {
                throw new RuntimeException("Senha inválida.");
            }
        } else {
            throw new UsernameNotFoundException("Usuário inválido");
        }
    }

    public UserDetails dadosAutenticacaoAutorizacao(String usuario) {
        Usuario user = usuarioRepository.findByUsuario(usuario).get();
        return new User(user.getUsuario(), user.getSenha(), new ArrayList<>());
    }

    public Usuario buscarDadosUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario).get();
    }

	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuarioPorChaveAtivacao(String chaveAtivacao) throws DadoInexistenteException {
		Optional<Usuario> u = usuarioRepository.findByChaveAtivacao(chaveAtivacao);
		if(!u.isPresent())
			throw new DadoInexistenteException("Chave de ativação", ", peça para o responsável cadastra-lo novamente.");
		return u.get(); 
	}

	public Usuario finalizarCadastroUsuario(Usuario usuario) throws DadoInexistenteException, DadoExistenteException {
		Optional<Usuario> user = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(user.isPresent())
			throw new DadoExistenteException("Usuário");
		
		Usuario u = buscarUsuarioPorChaveAtivacao(usuario.getChaveAtivacao());
		u.setUsuario(usuario.getUsuario());
		String senha = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
		u.setSenha(senha);
		u.setAtivo(true);
		u.setChaveAtivacao("");
		usuario = usuarioRepository.save(u);
		
		return loginAutomaticoViaSistema(usuario);
	}

	private Usuario loginAutomaticoViaSistema(Usuario usuario) {
		UserDetails userDetails = new User(usuario.getUsuario(), usuario.getSenha(),  new ArrayList<>());
		usuario.setToken(jwtTokenUtil.generateToken(userDetails));
		usuario.setUltimoLogin(new Date());
		Usuario user = usuarioRepository.save(usuario);
		user.setSenha("");
		return user;
	}
	
}
