package com.Java.Cedro.Servicio;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.Java.Cedro.UsuarioNoEncontrado;
import com.Java.Cedro.controlador.dto.UsuarioRegistroDTO;
import com.Java.Cedro.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService {

	public List<Usuario> listarTodosLosUsuarios();

	public Usuario guardarUsuario(Usuario usuario);

	public Usuario obtenerUsuarioPorId(Long id_usuario);

	public Usuario actualizarUsuario(Usuario usuario);

	public void eliminarUsuario(Long id_usuario);

	public Usuario guardar(UsuarioRegistroDTO registroDTO);

	public List<Usuario> listarUsuarios();
	


	
	
	
}
