package com.Java.Cedro.servicioImpl;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Java.Cedro.UsuarioNoEncontrado;
import com.Java.Cedro.Servicio.UsuarioServicio;
import com.Java.Cedro.controlador.dto.UsuarioRegistroDTO;
import com.Java.Cedro.modelo.Rol;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.repositorio.RolRepositorio;
import com.Java.Cedro.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private RolRepositorio Rrepositorio;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id_usuario) {
		
		return usuarioRepositorio.findById(id_usuario).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id_usuario) {
		usuarioRepositorio.deleteById(id_usuario);
		
	}

	// SignUp

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(),
				registroDTO.getTipo_documento(), registroDTO.getNumero_documento(), registroDTO.getTelefono(),
				registroDTO.getDireccion(), registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword()),
				Rrepositorio.asignarRol());
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
	
	//ResetPassword
	@Autowired
	private UsuarioRepositorio usuarioRepositorio2;
	
	public void updateResetPasswordToken(String token, String email) throws UsuarioNoEncontrado {
		Usuario usuario = usuarioRepositorio2.findByEmail(email);
		
		if(usuario != null) {
		   usuario.setResetPasswordToken(token);
		   usuarioRepositorio2.save(usuario);
		   
		}else {
			throw new UsuarioNoEncontrado("No se encontró el usuario con el correo: " + email);
		}

	}

	public Usuario get(String token) {
	
		return usuarioRepositorio2.findByResetPasswordToken(token);
	}

	
	public void updatePassword(Usuario usuario, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newPassword);
		
		usuario.setPassword(encodePassword);
		usuario.setResetPasswordToken(null);
		
		usuarioRepositorio2.save(usuario);
		
	}
	

}




