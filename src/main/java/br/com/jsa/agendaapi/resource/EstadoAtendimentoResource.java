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

import br.com.jsa.agendaapi.model.EstadoAtendimento;
import br.com.jsa.agendaapi.service.EstadoAtendimentoService;

@RestController
@RequestMapping("estado-atendimento")
@CrossOrigin
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoAtendimentoResource {
	
	@Autowired
	private EstadoAtendimentoService estadoAtendimentoService;
	
	@GetMapping("/lista-estado-atendimento")
	public ResponseEntity<?> listarEstadosAtenidmento(){
		Iterable<EstadoAtendimento> lstEstadoAtendimento = estadoAtendimentoService.listarEstadoAtendimento();
		return ResponseEntity.ok(lstEstadoAtendimento);
	}
	

}
