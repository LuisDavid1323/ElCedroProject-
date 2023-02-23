package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.Servicio.DisenoServicio;
import com.Java.Cedro.modelo.Diseno;


@Controller
public class DisenoControlador {

	@Autowired
	private DisenoServicio servicio;

	@GetMapping("/disenos")
	public String getDisenos(Model model) {
		List<Diseno> disenos = servicio.listarTodosLosDisenos();
		model.addAttribute("disenos", disenos);
		return "DisenoCRUD/disenos";
	}

	@GetMapping("/disenos/nuevo")
	public String mostrarFormularioDeRegistrtarDisenos(Model modelo) {
		Diseno diseno = new Diseno();
		modelo.addAttribute("disenos", diseno);

		return "DisenoCRUD/crear_diseno";
	}

	@PostMapping("/disenos")
	public String guardarDiseno(@ModelAttribute("diseno") Diseno diseno) {
		servicio.guardarDiseno(diseno);
		return "redirect:/disenos";
	}

	@GetMapping("/disenos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("disenos", servicio.obtenerDisenoPorId(id));

		return "DisenoCRUD/editar_diseno";
	}

	@PostMapping("disenos/{id}")
	public String actualizarDiseno(@PathVariable Integer id, @ModelAttribute("diseno") Diseno diseno,
			Model modelo) {
		Diseno d = servicio.obtenerDisenoPorId(id);

		d.setId_diseño(id);
		d.setNombre_d(diseno.getNombre_d());

		servicio.actualizarDiseno(diseno);
		return "redirect:/disenos";
	}
	
	@GetMapping("disenos/{id}")
	public String eliminarDiseno(@PathVariable Integer id) {
		servicio.eliminarDiseno(id);
		return "redirect:/disenos";
	}

}
