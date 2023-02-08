package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.Detalle_de_produccionServicio;
import com.Java.Cedro.Servicio.OrdenpServicio;
import com.Java.Cedro.Servicio.VentaServicio;
import com.Java.Cedro.modelo.Detalle_de_produccion;
import com.Java.Cedro.modelo.Venta;
import com.Java.Cedro.modelo.orden_de_produccion;

@Controller
public class OrdenpControlador {
	
	@Autowired
	private OrdenpServicio Oservicio;
	
	@Autowired
	private Detalle_de_produccionServicio Dservicio;
	
	@Autowired
	private VentaServicio Vservicio;
	
	
	
	@GetMapping({ "/ordenesp"})
	public String listarsalidas(Model modelo) {
		modelo.addAttribute("ordenesp", Oservicio.listarTodosLasOrdenes());
		return "OrdenpCRUD/Ordenp";
	}
	
	
	@GetMapping("/ordenesp/nuevo")
	public String mostrarFormularioDeRegistrarSalida(Model modelo) {
		
		List<Venta> lstV = Vservicio.listarTodosLasVentas();
		modelo.addAttribute("lstV", lstV);
		
		List<Detalle_de_produccion> lstD = Dservicio.listarTodosLosDetalle();   
		modelo.addAttribute("lstD", lstD);
		
		orden_de_produccion ordenp = new orden_de_produccion();

		
		modelo.addAttribute("ordenesp", ordenp);
		return "OrdenpCRUD/Crear_Ordenp";
	}

	@PostMapping("/ordenesp")
	public String guardarOrdenp(@ModelAttribute("ordenesp") orden_de_produccion ordenesp) {
		Oservicio.guardarOrden(ordenesp);
		return "redirect:/ordenesp";
	}
	
	
	@GetMapping("/ordenesp/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Venta> lstV = Vservicio.listarTodosLasVentas();
		modelo.addAttribute("lstV", lstV);
		
		List<Detalle_de_produccion> lstD = Dservicio.listarTodosLosDetalle();   
		modelo.addAttribute("lstD", lstD);

		modelo.addAttribute("ordenesp", Oservicio.obtenerOrdenPorId(id));
		return "OrdenpCRUD/Editar_Ordenp";
	}
	
	@PostMapping("/ordenesp/{id}")
	public String actualizarOrdenp(@PathVariable Integer id, @ModelAttribute("ordenesp") orden_de_produccion ordenesp, Model modelo) {

		orden_de_produccion O = Oservicio.obtenerOrdenPorId(id);
		
		O.setId_orden_de_produccion(id);
		O.setFecha(ordenesp.getFecha());
		O.setId_detallePro_fk(ordenesp.getId_detallePro_fk());
		O.setId_venta_fk(ordenesp.getId_venta_fk());
		
		Oservicio.actualizarOrden(O);
		return "redirect:/ordenesp";
	}
	
	@GetMapping("/ordenesp/{id}")
	public String eliminarOrden(@PathVariable Integer id) {
		Oservicio.eliminarOrden(id);
		return "redirect:/ordenesp";
	}
	
	

}
