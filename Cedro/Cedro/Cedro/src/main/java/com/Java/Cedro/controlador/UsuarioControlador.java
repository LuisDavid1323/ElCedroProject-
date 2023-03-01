package com.Java.Cedro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Java.Cedro.Servicio.RolServicio;
import com.Java.Cedro.Servicio.UsuarioServicio;
import com.Java.Cedro.modelo.Rol;
import com.Java.Cedro.modelo.Usuario;

@Controller
public class UsuarioControlador {

	@Autowired
	private RolServicio rolservi;

	@Autowired
	private UsuarioServicio servicio;

	@GetMapping({ "/users" })
	public String listarUsario(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarTodosLosUsuarios());

		List<Rol> lstrol = rolservi.lstrol();
		modelo.addAttribute("rol", lstrol);

		return "UsuarioCRUD/usuarios";
	}

	@GetMapping("/users/nuevo")
	public String mostrarFormularioDeRegistrtarUsuarios(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuarios", usuario);
		
		List<Rol> lstrol = rolservi.lstrol();
		modelo.addAttribute("rol", lstrol);
		return "UsuarioCRUD/crear_usuario";
	}

	@PostMapping("/users")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		servicio.guardarUsuario(usuario);
		return "redirect:/users";
	}

	@PostMapping("/save")
	public Usuario save(@RequestBody Usuario usuario) throws Exception {

		return servicio.guardarUsuario(usuario);
	}

	@GetMapping("/users/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuarios", servicio.obtenerUsuarioPorId(id));

		List<Rol> lstrol = rolservi.lstrol();
		modelo.addAttribute("rol", lstrol);

		return "UsuarioCRUD/editar_usuario";
	}

	@PostMapping("users/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario,
			Model modelo) {
		Usuario usuarioE = servicio.obtenerUsuarioPorId(id);
		usuarioE.setId_usuario(id);
		usuarioE.setNombre(usuario.getNombre());
		usuarioE.setApellido(usuario.getApellido());
		usuarioE.setTipo_documento(usuario.getTipo_documento());
		usuarioE.setNumero_documento(usuario.getNumero_documento());
		usuarioE.setDireccion(usuario.getDireccion());
		usuarioE.setTelefono(usuario.getTelefono());
		usuarioE.setEmail(usuario.getEmail());

		servicio.actualizarUsuario(usuarioE);
		return "redirect:/users";
	}

	@GetMapping("users/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		servicio.eliminarUsuario(id);
		return "redirect:/users";
	}
}
