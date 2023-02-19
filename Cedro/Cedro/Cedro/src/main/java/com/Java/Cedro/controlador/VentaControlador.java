package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Java.Cedro.Servicio.OrdenpServicio;
import com.Java.Cedro.Servicio.UsuarioServicio;
import com.Java.Cedro.Servicio.VentaServicio;
import com.Java.Cedro.modelo.Usuario;
import com.Java.Cedro.modelo.Venta;
import com.Java.Cedro.modelo.orden_de_produccion;

@Controller
public class VentaControlador {
	
	@Autowired
	private VentaServicio servicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private OrdenpServicio ordenServicio;
	
	
	
	@GetMapping({ "/ventas" })
	public String listarVentas(Model modelo) {
		modelo.addAttribute("ventas", servicio.listarTodosLasVentas());
		return "VentaCRUD/Venta";
	}
	
	@GetMapping("/ventas/nuevo")
	public String mostrarFormularioDeRegistrtarVenta(Model modelo) {
		
		List<Usuario> lstU = usuarioServicio.listarTodosLosUsuarios();
		modelo.addAttribute("lstU", lstU);
		
		List<orden_de_produccion> lstOrdenp = ordenServicio.listarTodosLasOrdenes();
		modelo.addAttribute("lstOrdenp", lstOrdenp);
		
		Venta venta = new Venta();

		
		
		modelo.addAttribute("ventas", venta);
		return "VentaCRUD/Crear_Venta";
	}
	
	@PostMapping("/ventas")
	public String guardarVenta(@ModelAttribute("ventas") Venta venta) {
		servicio.guardarVenta(venta);
		return "redirect:/ventas";
	}
	
	
	@GetMapping("/ventas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Usuario> lstU = usuarioServicio.listarTodosLosUsuarios();
		modelo.addAttribute("lstU", lstU);
		
		List<orden_de_produccion> lstOrdenp = ordenServicio.listarTodosLasOrdenes();
		modelo.addAttribute("lstOrdenp", lstOrdenp);

		modelo.addAttribute("ventas", servicio.obtenerVentaPorId(id));
		return "VentaCRUD/Editar_Venta";
	}
	
	@PostMapping("/ventas/{id}")
	public String actualizarVenta(@PathVariable Integer id, @ModelAttribute("venta") Venta venta, Model modelo) {

		Venta V = servicio.obtenerVentaPorId(id);
		
		V.setId_ventas(id);
		V.setFecha(venta.getFecha());
		V.setId_Usuarios_fk(venta.getId_Usuarios_fk());
		V.setId_ordenDeProduccion_fk(venta.getId_ordenDeProduccion_fk());
	
		
		servicio.actualizarVenta(V);
		return "redirect:/ventas";
	}
	
	@GetMapping("/ventas/{id}")
	public String eliminarVenta(@PathVariable Integer id) {
		servicio.eliminarVenta(id);
		return "redirect:/ventas";
	}

	
}
