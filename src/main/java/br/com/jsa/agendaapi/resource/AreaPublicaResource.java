package br.com.jsa.agendaapi.resource;

import javax.mail.MessagingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.agendaapi.config.JwtTokenUtil;
import br.com.jsa.agendaapi.exception.DadoExistenteException;
import br.com.jsa.agendaapi.exception.DadoInexistenteException;
import br.com.jsa.agendaapi.model.ObjetoLogin;
import br.com.jsa.agendaapi.model.Usuario;
import br.com.jsa.agendaapi.service.UsuarioService;

@RestController
@RequestMapping("area-publica")
@CrossOrigin
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AreaPublicaResource {

	@Autowired
	private UsuarioService usuarioService;
	
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody ObjetoLogin objetoLogin) {
        try {
            Usuario u = new Usuario();

            final UserDetails userDetails = usuarioService.login(objetoLogin);
            u = usuarioService.verificarUsuarioOuEmail(objetoLogin, u);
            u.setSenha("");
            u.setToken(jwtTokenUtil.generateToken(userDetails));

            return ResponseEntity.ok(u);
        }catch (RuntimeException | DadoExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@PostMapping("/adicionar-novo-usuario")
	public ResponseEntity<?> listarUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioService.salvarNovoUsuarioFuncionario	(usuario);
			return ResponseEntity.ok().build();
		} catch (MessagingException e) {
			return ResponseEntity.badRequest().body("Tivemos um problema ao enviar os dados de ativação do usuário para o email, favor entrar no painel gerenciamento do usuário e solicitar o envio novamente.");
		} catch (DadoExistenteException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/buscar-token-usuario-ativacao")
	public ResponseEntity<?> buscarTokenUsuarioAtivacao(@RequestBody String chaveAtivacao){
		try {
			Usuario u = usuarioService.buscarUsuarioPorChaveAtivacao(chaveAtivacao);
			return ResponseEntity.ok().body(u);
		} catch (DadoInexistenteException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/finalizar-cadastro-usuario")
	public ResponseEntity<?> finalizarCadastroUsuarioFuncionario(@RequestBody Usuario usuario){
		try {
			usuarioService.finalizarCadastroUsuario(usuario);
			return ResponseEntity.ok().build();
		} catch (DadoInexistenteException | DadoExistenteException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
