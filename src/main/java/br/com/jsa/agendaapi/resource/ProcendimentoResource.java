package br.com.jsa.agendaapi.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.agendaapi.model.Procedimento;
import br.com.jsa.agendaapi.service.ProcedimentoService;

@RestController
@RequestMapping("procedimento")
@CrossOrigin
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcendimentoResource {
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@PostMapping("salvar")
	public ResponseEntity<?> salvar(@RequestBody Procedimento procedimento){
		procedimentoService.salvarProcedimento(procedimento);
		return ResponseEntity.ok().build();
	}

}
