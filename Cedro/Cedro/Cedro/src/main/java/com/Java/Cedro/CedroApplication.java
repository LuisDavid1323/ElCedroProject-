package com.Java.Cedro;

import com.Java.Cedro.Servicio.EmailServicio;
import com.Java.Cedro.Servicio.UsuarioServicio;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.repositorio.UsuarioRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class CedroApplication implements CommandLineRunner {

	@Autowired
	private EmailServicio emailServicio;

	@Autowired
	private UsuarioRepositorio userRepositorio;

	@Autowired
	JavaMailSender mailSender;

	//@Autowired
	//private UsuarioServicio servicio;

	public static void main(String[] args) {
		SpringApplication.run(CedroApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// new
	// EnvioEmail().sendEmail(servicio.listarTodosLosUsuarios(),"asunto","contenido");
	// }
	
	@Override
	public void run(String... args) throws Exception {
		List<Usuario> lstUsuarios = this.userRepositorio.findAll();
		lstUsuarios.forEach(usuario -> { 
			this.emailServicio.enviarEmail(usuario.getEmail(), "Hi", "This is a test");
		});
		
	}
}
