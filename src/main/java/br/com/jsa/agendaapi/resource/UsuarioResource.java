package br.com.jsa.agendaapi.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.agendaapi.service.UsuarioService;

@RestController
@RequestMapping("usuario")
@CrossOrigin
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/teste")
	public ResponseEntity<?> listarUsuario() {
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
}
