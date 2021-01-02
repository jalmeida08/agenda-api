package br.com.jsa.agendaapi.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MensageriaService {

	@Autowired private JavaMailSender mailSender;
	private final String linkBaseAtivacao = "http://localhost:4200/";
	
	private boolean enviarEmail(String destinatario, String tituloEmail, String textoEmail) throws MessagingException {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo(destinatario);
			helper.setSubject(tituloEmail);
			helper.setText(textoEmail, true);
			
			mailSender.send(mail);
			return true;
	}

	public void enviarEmailNovoUsuario(String destinatario, String nome, String chaveAtivacao) throws MessagingException{
		final String tituloEmail = "Bem vindo a angeda da Polly Silva - Estética e Beleza";
		String linkParaAtivarUsuario = linkBaseAtivacao + "habilitar-cadastro-usuario/";
		linkParaAtivarUsuario += chaveAtivacao;
		String textoEmail = "<html> <head>"
		+ "<style>"
		+ ".botao:hover {background-color: rgba(135,206,250,0.5)}"
		+ ".botao {background-color: #87CEFA; padding: 10px; color: #000; border-radius: 3px; text-decoration: none}"
		+ "</style>"
		+ "</head> <body>"
		+ "<h1>Bem vindo, "+nome+"!</h1>"
		+ "<br>"
		+ "<p>Este e-mail contém informações para lhe ajudar a finalizar o seu cadastro no sitema de agendas da <strong>Polly Silva - Estética e Beleza</strong></p>"
		+ "<br>"
		+ "<p>Clique no botão, preencha as informações necessárias para finalizar o seu cadastro: "
		+ "<a class='botao' href='"+linkParaAtivarUsuario+"'>Finalizar cadastro</a></p>"
		+ "<br><br><br><br><br><br><br><br>"
		+ "Caso o botão não funcione, clique no link: <a href='"+ linkParaAtivarUsuario +"'>" + linkParaAtivarUsuario + "</a>"
		+ "</body></html>";
		enviarEmail(destinatario, tituloEmail, textoEmail);
	}


}
