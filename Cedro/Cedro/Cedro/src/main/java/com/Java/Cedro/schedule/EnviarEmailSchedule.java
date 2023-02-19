package com.Java.Cedro.schedule;

import java.util.List;

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
	
	@Scheduled(fixedRate = 3600000)
	public void ejecutarSchedule() {
		List<Usuario> lstUsuarios = this.userRepositorio.findAll();
		lstUsuarios.forEach(usuario -> { 
			this.emailServicio.enviarEmail(usuario.getEmail(), "Hola, " + usuario.getNombre() + ' ' +usuario.getApellido(), "Estamos ejecutando el Schedule");
		});
	}
}
