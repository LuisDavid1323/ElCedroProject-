package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.CotizacionServicio;
import com.Java.Cedro.Servicio.EstadocServicio;
import com.Java.Cedro.modelo.Cotizacion;
import com.Java.Cedro.modelo.Estado_cotizacion;

@Controller
public class EstadocControlador {

	@Autowired
	private EstadocServicio Eservicio;
	
	@Autowired
	private CotizacionServicio Cservicio;
	
	@GetMapping({ "/estadosc" })
	public String listarsalidas(Model modelo) {
		modelo.addAttribute("estadosc", Eservicio.listarTodosLosEstado());
		return "EstadocCRUD/Estadoc";
	}
	
	@GetMapping("/estadosc/nuevo")
	public String mostrarFormularioDeRegistrarEstadosc(Model modelo) {
		
		List<Cotizacion> lstC = Cservicio.listarTodosLasCotizaciones();
		modelo.addAttribute("lstC", lstC);
		
		
		Estado_cotizacion estadosc = new Estado_cotizacion();

		
		modelo.addAttribute("estadosc", estadosc);
		return "EstadocCRUD/Crear_Estadoc";
	}
	
	@PostMapping("/estadosc")
	public String guardarSalida(@ModelAttribute("estadosc") Estado_cotizacion estadosc) {
		Eservicio.guardarEstado(estadosc);
		return "redirect:/estadosc";
	}
	
	@GetMapping("/estadosc/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Cotizacion> lstC = Cservicio.listarTodosLasCotizaciones();
		modelo.addAttribute("lstC", lstC);

		modelo.addAttribute("estadosc", Eservicio.obtenerEstadoPorId(id));
		return "EstadocCRUD/Editar_Estadoc";
	}
	
	
	@PostMapping("/estadosc/{id}")
	public String actualizarSalida(@PathVariable Integer id, @ModelAttribute("estadosc") Estado_cotizacion estadosc, Model modelo) {

		Estado_cotizacion Ec = Eservicio.obtenerEstadoPorId(id);
		
		Ec.setId_estado_cotizacion(id);
		Ec.setNombre_estado_cotizacion(estadosc.getNombre_estado_cotizacion());
		//Ec.setId_cotizacion_fk(estadosc.getId_cotizacion_fk());
		
		Eservicio.actualizarEstado(Ec);
		return "redirect:/estadosc";
	}
	
	@GetMapping("/estadosc/{id}")
	public String eliminarEstado(@PathVariable Integer id) {
		Eservicio.eliminarEstado(id);
		return "redirect:/estadosc";
	}
	
	
	
}
