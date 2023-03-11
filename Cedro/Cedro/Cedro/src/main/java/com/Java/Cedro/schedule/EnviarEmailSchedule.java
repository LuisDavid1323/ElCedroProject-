package com.Java.Cedro.schedule;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.Java.Cedro.Servicio.EmailServicio;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.repositorio.UsuarioRepositorio;

@Component
public class EnviarEmailSchedule {
	
	@Autowired
	private EmailServicio emailServicio;

	@Autowired
	private UsuarioRepositorio userRepositorio;
	
//	@Scheduled(fixedRate = 3600000)
//	public void ejecutarSchedule() {
//		List<Usuario> lstUsuarios = this.userRepositorio.findAll();
//		lstUsuarios.forEach(usuario -> { 
//			String pageF = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n"
//					+ "<HTML>\r\n"
//					+ "\r\n"
//					+ "<HEAD>\r\n"
//					+ "   <meta charset=\"utf-8\">\r\n"
//					+ "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
//					+ "   <style>\r\n"
//					+ "      * {\r\n"
//					+ "         font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\r\n"
//					+ "      }\r\n"
//					+ "      a{\r\n"
//					+ "         text-decoration: none;\r\n"
//					+ "         color: #DBBA9D;\r\n"
//					+ "      }\r\n"
//					+ "      a:hover{\r\n"
//					+ "         color:#663E39 ;\r\n"
//					+ "      }\r\n"
//					+ "   </style>\r\n"
//					+ "\r\n"
//					+ "   <TITLE>Maderas Finas - flyer</TITLE>\r\n"
//				+ "   \r\n"
//				+ "</HEAD>\r\n"
//					+ "\r\n"
//					+ "<BODY style=\"margin: 0; padding: 0;\">   \r\n"
//					+ "  \r\n"
//					+ "  \r\n"
//					+ "   \r\n"
//					+ "\r\n"
//					+ "   <!-- Encabezado -->\r\n"
//					+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"440\" style=\"border-collapse: collapse;\">\r\n"
//					+ "		<tr>\r\n"
//					+ "			<td style=\"background-color: #663E39; padding: 15px; text-align: center;\">\r\n"
//					+ "				<h1 style=\"color: #FFFFFF; margin: 0;\">NUEVA OFERTA!!</h1>\r\n"
//					+ "			</td>\r\n"
//					+ "		</tr>\r\n"
//					+ "	</table>\r\n"
//					+ "\r\n"
//					+ "	<!-- Cuerpo -->\r\n"
//					+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; margin-top: 20px;\">\r\n"
//					+ "		<tr>\r\n"
//					+ "			<td style=\"padding: 20px;\">\r\n"
//					+ "            \r\n"
//					+ "            <center>\r\n"
//					+ "				<img style=\"height: 700px;\" src=\"https://i.postimg.cc/zB5gzgfb/Flayer.jpg\" />\r\n"
//					+ "            </center>\r\n"
//					+ "			</td>\r\n"
//					+ "		</tr>\r\n"
//					+ "	</table>\r\n"
//					+ "\r\n"
//					+ "	<!-- Pie de página -->\r\n"
//					+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"440\" style=\"border-collapse: collapse;\">\r\n"
//					+ "		<tr>\r\n"
//					+ "			<td style=\"background-color: #DBBA9D; padding: 20px; text-align: center;\">\r\n"
//					+ "				<p style=\"color: #000000; font-size: 14px; line-height: 20px; margin: 0;\">copyright &copy;2023 El Cedro.</p>\r\n"
//					+ "			</td>\r\n"
//					+ "		</tr>\r\n"
//					+ "	</table>\r\n"
//					+ "</BODY>\r\n"
//					+ "\r\n"
//					+ "</HTML>";
//			try {
//				this.emailServicio.enviarEmail(usuario.getEmail(), "📌 Hola, " + usuario.getNombre() + ' ' +usuario.getApellido()+ " tenemos una nueva oferta para ti.", pageF);
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//	}
}
