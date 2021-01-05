package br.com.jsa.agendaapi.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.agendaapi.model.Atendimento;
import br.com.jsa.agendaapi.service.AtendimentoService;

@RestController
@RequestMapping("atendimento")
@CrossOrigin
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AtendimentoResource {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@PostMapping("/salvar")
	public void salvar(Atendimento atendimento) {
		atendimentoService.salvar(atendimento);
	}
	
	
}
