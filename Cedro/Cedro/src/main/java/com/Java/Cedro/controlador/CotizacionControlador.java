package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Java.Cedro.Servicio.CotizacionServicio;
import com.Java.Cedro.Servicio.DetalleCotizacionServicio;
import com.Java.Cedro.Servicio.EmailServicio;
import com.Java.Cedro.Servicio.UsuarioServicio;
import com.Java.Cedro.modelo.Cotizacion;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.schedule.EnviarEmailSchedule;



@Controller
public class CotizacionControlador {
	
	@Autowired
	private CotizacionServicio CServicio;

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private DetalleCotizacionServicio detalleServicio;
	
	
	
	@GetMapping("/cotizacion/pagar/{id}")
	public String pagarCotizacion(@PathVariable Integer id){
		this.CServicio.pagarCotizacion(id);
		return "CotizacionCRUD/ConfirmarPago";
	}
	
	
	
	@GetMapping({ "/cotizaciones"})
	public String listarCotizaciones(Model modelo) {
		modelo.addAttribute("cotizaciones", CServicio.listarTodosLasCotizaciones());
		return "CotizacionCRUD/Cotizacion";
	}
	
	@GetMapping("/cotizaciones/nuevo")
	public String mostrarFormularioDeRegistrarCotizacion(Model modelo) {
		
		
		
		List<Usuario> lstU = usuarioServicio.listarTodosLosUsuarios();
		modelo.addAttribute("lstU", lstU);
		
		List<Detalle_cotizacion> lstD = detalleServicio.listarTodosLosDetalle();
		modelo.addAttribute("lstD", lstD);
		
		
		Cotizacion cotizacion = new Cotizacion();
		modelo.addAttribute("cotizaciones", cotizacion);
		
		return "CotizacionCRUD/Crear_Cotizacion";
	}
	
	@PostMapping("/cotizaciones")
	public String guardarCotizacion(@ModelAttribute("cotizaciones") Cotizacion cotizacion) {
		CServicio.guardarCotizacion(cotizacion);
		return "redirect:/cotizaciones";
	}
	
	
	@GetMapping("/cotizaciones/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		

		modelo.addAttribute("cotizaciones", CServicio.obtenerCotizacionPorId(id));
		return "CotizacionCRUD/Editar_Cotizacion";
	}
	
	
	@PostMapping("/cotizaciones/{id}")
	public String actualizarCotizacion(@PathVariable Integer id, @ModelAttribute("cotizacion") Cotizacion cotizacion, Model modelo) {

		Cotizacion C = CServicio.obtenerCotizacionPorId(id);
		
		C.setId_cotizacion(id);
		C.setFecha(cotizacion.getFecha());
		C.setValorTotal(cotizacion.getValorTotal());
		C.setEstadoCotizacion(cotizacion.getEstadoCotizacion());
		C.setId_detalle_cotizacion_fk(cotizacion.getId_detalle_cotizacion_fk());
		C.setId_Usuarios_fk(cotizacion.getId_Usuarios_fk());
		
		
		CServicio.actualizarCotizacion(C);
		return "redirect:/cotizaciones";
	}
	
	@GetMapping("/cotizaciones/{id}")
	public String eliminarCotizacion(@PathVariable Integer id) {
		CServicio.eliminarCotizacion(id);
		return "redirect:/cotizaciones";
	}
	
	
	
}
