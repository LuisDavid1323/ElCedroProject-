package com.Java.Cedro.controlador;

import com.Java.Cedro.Servicio.TelaServicio;
import com.Java.Cedro.modelo.Rol;
import com.Java.Cedro.modelo.Tela;
import com.Java.Cedro.modelo.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TelaControlador {
	
	@Autowired
	private TelaServicio TServicio;


	@GetMapping({ "/cloth" })
	public String listarTela(Model modelo) {
		modelo.addAttribute("telas", TServicio.listarTodasLasTelas());

		return "TelaCRUD/Telas";
	}

	@GetMapping("/cloth/nuevo")
	public String mostrarFormularioDeRegistrtarTela(Model modelo) {
		Tela tela = new Tela();
		modelo.addAttribute("telas", tela);
		
		return "TelaCRUD/Crear_Telas";
	}

	@PostMapping("/cloth")
	public String guardarTela(@ModelAttribute("tela") Tela tela) {
		TServicio.guardarTela(tela);
		return "redirect:/cloth";
	}

	@GetMapping("/cloth/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("telas", TServicio.obtenerTelaPorId(id));

		return "TelaCRUD/Editar_Telas";
	}

	@PostMapping("cloth/{id}")
	public String actualizarTela(@PathVariable Integer id, @ModelAttribute("tela") Tela tela,
			Model modelo) {
		Tela t = TServicio.obtenerTelaPorId(id);
		t.setId_telas(id);
		t.setNombre_tela(tela.getNombre_tela());
		t.setValor(tela.getValor());

		TServicio.actualizarTela(tela);
		return "redirect:/cloth";
	}

	@GetMapping("cloth/{id}")
	public String eliminarTela(@PathVariable Integer id) {
		TServicio.eliminarTela(id);
		return "redirect:/cloth";
	}

}
