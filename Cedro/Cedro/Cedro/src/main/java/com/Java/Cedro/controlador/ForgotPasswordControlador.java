package com.Java.Cedro.controlador;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.UsuarioNoEncontrado;
import com.Java.Cedro.Servicio.EmailServicio;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.Utilities.Utility;
import com.Java.Cedro.servicioImpl.UsuarioServicioImpl;

@Controller
public class ForgotPasswordControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;
	
	@Autowired
	private EmailServicio emailServicio;
	
	

	@GetMapping("/forgot_password")
	public String showForm(Model model) {
		model.addAttribute("pageTitle", "Forgot Password");
		return "/LogIn/Recuperar";
	}

	@PostMapping("/forgot_password")
	public String processForgotPassword(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		
//		System.out.println("Aqui me estoy quedando (process)");
//        System.out.println("Este es el token e email del so: " + email + token); 
        

		try {
			usuarioServicio.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteUrl(request) + "/reset_password?token=" + token;
			
			
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to your email. Please check.");       
			 
		} catch (UsuarioNoEncontrado ex) {

			model.addAttribute("error", ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error enviando el correo");
		}
		
		
		return "/LogIn/Recuperar";
	}

	private void sendEmail(String email, String resetPasswordLink)
			throws MessagingException, UnsupportedEncodingException {
		
        
		String page = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n"
				+ "<HTML>\r\n"
				+ "\r\n"
				+ "<HEAD>\r\n"
				+ "   <meta charset=\"utf-8\">\r\n"
				+ "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "   <style>\r\n"
				+ "      * {\r\n"
				+ "         font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\r\n"
				+ "      }\r\n"
				+ "      a{\r\n"
				+ "         text-decoration: none;\r\n"
				+ "         color: #DBBA9D;\r\n"
				+ "      }\r\n"
				+ "      a:hover{\r\n"
				+ "         color:#663E39 ;\r\n"
				+ "      }\r\n"
				+ "   </style>\r\n"
				+ "\r\n"
				+ "   <TITLE>Maderas Finas - Restablecer</TITLE>\r\n"
				+ "   \r\n"
				+ "</HEAD>\r\n"
				+ "\r\n"
				+ "<BODY style=\"margin: 0; padding: 0;\">   \r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "   \r\n"
				+ "\r\n"
				+ "   <!-- Encabezado -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"background-color: #663E39; padding: 20px; text-align: center;\">\r\n"
				+ "				<h1 style=\"color: #FFFFFF; margin: 0;\">Restablecimiento de contraseña</h1>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "\r\n"
				+ "	<!-- Cuerpo -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; margin-top: 20px;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"padding: 20px;\">\r\n"
				+ "            \r\n"
				+ "            <center><img  src=\"https://i.postimg.cc/mkky1hxL/logo.jpg\" style=\"height: 200px;width: 400px;\"/></center>\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">Hola\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">por medio de este <a href=\"" + resetPasswordLink + "\">link</a>  podrás restablecer tu contraseña.</p>\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">Gracias por confiar en nosotros.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "\r\n"
				+ "	<!-- Pie de página -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; margin-top: 20px;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"background-color: #DBBA9D; padding: 20px; text-align: center;\">\r\n"
				+ "				<p style=\"color: #000000; font-size: 14px; line-height: 20px; margin: 0;\">copyright &copy;2023 El Cedro.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "</BODY>\r\n"
				+ "\r\n"
				+ "</HTML>";
		
		
		this.emailServicio.enviarEmail2(email,"Restablecimiento de contraseña 🔑 ", page);
	}

	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
	    
		Usuario usuario =  this.usuarioServicio.get(token);
	    
	  
	    if (usuario == null) {
	        model.addAttribute("title", "Restablece tu contraseña");
	        model.addAttribute("message", "Token invalido");
	        return "/LogIn/message";
    }
	   
	    model.addAttribute("token", token);
	    model.addAttribute("pageTitle", "Reset your Password");
	    
	    return "reset_password_form";
	}
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		
		Usuario usuario = usuarioServicio.get(token);
		
		usuarioServicio.updatePassword(usuario, password);
		
		return "logIn";

	}
}
