package br.com.jsa.agendaapi.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public void salvar(@RequestBody Atendimento atendimento) {
		atendimentoService.salvar(atendimento);
	}
	
	@GetMapping("/atendimentos-dia-atual")
	public ResponseEntity<?> listaAtendimentoDia(){
		Iterable<Atendimento> lstAtendimentoDIa =
				atendimentoService.listaAtendimentoDia();
		return ResponseEntity.ok(lstAtendimentoDIa);
	}
	
	@PostMapping("/atendimentos-dia-selecionado")
	public ResponseEntity<?> listaAtendimentoDiaSelecionado(@RequestBody Date dataAgendamento){
		List<Atendimento> lstAtendimentoDiaSelecionado =
				atendimentoService.listaAtendimentoDiaSelecionado(dataAgendamento);
		return ResponseEntity.ok(lstAtendimentoDiaSelecionado);
	}
	
}
