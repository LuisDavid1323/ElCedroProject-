package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.EntradaServicio;
import com.Java.Cedro.Servicio.InsumoServicio;
import com.Java.Cedro.modelo.Entrada;
import com.Java.Cedro.modelo.Insumo;

@Controller
public class EntradaControlador {
	
	@Autowired 
	private EntradaServicio servicio;
	
	@Autowired
	private InsumoServicio Iservicio;
	
	@GetMapping({ "/entradas" })
	public String listarEntradas(Model modelo) {
		modelo.addAttribute("entradas", servicio.listarTodosLasEntradas());         
		return "EntradaCRUD/Entrada";
	}
	
	@GetMapping("/entradas/nuevo")
	public String mostrarFormularioDeRegistrarEntrada(Model modelo) {
		List<Insumo> lstI = Iservicio.listarTodosLosInsumos();

		Entrada entrada = new Entrada();

		modelo.addAttribute("lstI", lstI);
		modelo.addAttribute("entradas", entrada);
		return "EntradaCRUD/Crear_Entrada";
	}
	
	@PostMapping("/entradas")
	public String guardarEntrada(@ModelAttribute("entradas") Entrada entrada) {
		servicio.guardarEntrada(entrada);
		return "redirect:/entradas";
	}
	
	@GetMapping("/entradas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Insumo> lstI = Iservicio.listarTodosLosInsumos();
		modelo.addAttribute("lstI", lstI);

		modelo.addAttribute("entradas", servicio.obtenerEntradaPorId(id));
		return "EntradaCRUD/Editar_Entrada";
	}
	
	@PostMapping("/entradas/{id}")
	public String actualizarEntrada(@PathVariable Integer id, @ModelAttribute("entrada") Entrada entrada, Model modelo) {

		Entrada E = servicio.obtenerEntradaPorId(id);

		E.setId_entrada(id);
		E.setFecha(entrada.getFecha());
		E.setCantidad(entrada.getCantidad());
		E.setId_insumo_fk(entrada.getId_insumo_fk());
		
		
		servicio.actualizarEntrada(E);
		return "redirect:/entradas";
	}

	@GetMapping("/entradas/{id}")
	public String eliminarEntrada(@PathVariable Integer id) {
		servicio.eliminarEntrada(id);
		return "redirect:/entradas";
	}
	
	
	
}
