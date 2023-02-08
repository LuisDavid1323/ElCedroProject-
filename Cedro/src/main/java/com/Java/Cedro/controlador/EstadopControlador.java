package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.EstadopServicio;
import com.Java.Cedro.Servicio.OrdenpServicio;
import com.Java.Cedro.modelo.Estado_orden_produccion;
import com.Java.Cedro.modelo.orden_de_produccion;

@Controller
public class EstadopControlador {
	
	@Autowired
	private EstadopServicio Eservicio;
	
	@Autowired
	private OrdenpServicio Oservicio;

	
	@GetMapping({ "/estadosp"})
	public String listarsalidas(Model modelo) {
		modelo.addAttribute("estadosp", Eservicio.listarTodosLosEstadosp());
		return "EstadopCRUD/Estadop";
	}
	
	
	@GetMapping("/estadosp/nuevo")
	public String mostrarFormularioDeRegistrarEstado(Model modelo) {
		
		
		List<orden_de_produccion> lstO = Oservicio.listarTodosLasOrdenes();
		modelo.addAttribute("lstO", lstO);
		
		Estado_orden_produccion Estadop = new Estado_orden_produccion();

		
		modelo.addAttribute("estadosp", Estadop);
		return "EstadopCRUD/Crear_Estadop";
	}
	
	@PostMapping("/estadosp")
	public String guardarSalida(@ModelAttribute("estadosp") Estado_orden_produccion estadosp) {
		Eservicio.guardarEstadop(estadosp);
		return "redirect:/estadosp";
	}
	
	@GetMapping("/estadosp/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<orden_de_produccion> lstO = Oservicio.listarTodosLasOrdenes();
		modelo.addAttribute("lstO", lstO);

		modelo.addAttribute("estadosp", Eservicio.obtenerEstadopPorId(id));
		return "EstadopCRUD/Editar_Estadop";
	}
	
	
	@PostMapping("/estadosp/{id}")
	public String actualizarEstadop(@PathVariable Integer id, @ModelAttribute("estadosp") Estado_orden_produccion estadosp, Model modelo) {

		Estado_orden_produccion E = Eservicio.obtenerEstadopPorId(id);
		
		E.setId_estado_produccion(id);
		E.setNombre_estado_produccion(estadosp.getNombre_estado_produccion());
		
		
		Eservicio.actualizarEstadop(E);
		return "redirect:/estadosp";
	}
	
	@GetMapping("/estadosp/{id}")
	public String eliminarEstadop(@PathVariable Integer id) {
		Eservicio.eliminarEstadop(id);
		return "redirect:/estadosp";
	}
	
	
	
	
	
}
