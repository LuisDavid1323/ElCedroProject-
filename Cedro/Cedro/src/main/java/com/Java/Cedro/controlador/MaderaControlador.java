package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.MaderaServicio;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.modelo.Producto;

@Controller
public class MaderaControlador {
	
	@Autowired
	private MaderaServicio maderaServicio;
	
	@GetMapping("/maderas")
	public String getMaderas(Model model) {
		List<Madera> maderas = maderaServicio.listarTodasLasMadera();      
		model.addAttribute("maderas", maderas);
		return "MaderaCRUD/Maderas";
	}
	
	@GetMapping("/maderas/nuevo")
	public String mostrarFormularioDeRegistrtarMaderas(Model modelo) {
		Madera maderas = new Madera();
		modelo.addAttribute("maderas", maderas);

		return "MaderaCRUD/Crear_Maderas";
	}
	
	@PostMapping("/maderas")
	public String guardarMadera(@ModelAttribute("maderas") Madera maderas) {
		maderaServicio.guardarMadera(maderas);
		return "redirect:/maderas";
	}
	
	@GetMapping("/maderas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {   
		modelo.addAttribute("maderas", maderaServicio.obtenerMaderaPorId(id));

		return "MaderaCRUD/Editar_Maderas";
	}
	
	@PostMapping("maderas/{id}")
	public String actualizarMadera(@PathVariable Integer id, @ModelAttribute("maderas") Madera maderas,
			Model modelo) {
		Madera m = maderaServicio.obtenerMaderaPorId(id);

		m.setId_maderas(id);
		m.setNombre_madera(maderas.getNombre_madera());
		m.setPrecio(maderas.getPrecio());

		maderaServicio.actualizarMadera(maderas);
		return "redirect:/maderas";
	}
	
	@GetMapping("maderas/{id}")
	public String eliminarMadera(@PathVariable Integer id) {
		maderaServicio.eliminarMadera(id);
		return "redirect:/maderas";
	}
	
}
