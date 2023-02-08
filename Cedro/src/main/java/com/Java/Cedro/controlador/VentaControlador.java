package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.Servicio.VendedorServicio;
import com.Java.Cedro.Servicio.VentaServicio;
import com.Java.Cedro.modelo.Vendedor;
import com.Java.Cedro.modelo.Venta;

@Controller
public class VentaControlador {
	
	@Autowired
	private VentaServicio servicio;
	
	@Autowired
	private VendedorServicio Vservicio;
	
	
	
	@GetMapping({ "/ventas" })
	public String listarVentas(Model modelo) {
		modelo.addAttribute("ventas", servicio.listarTodosLasVentas());
		return "VentaCRUD/Venta";
	}
	
	@GetMapping("/ventas/nuevo")
	public String mostrarFormularioDeRegistrtarVenta(Model modelo) {
		
		List<Vendedor> lstV = Vservicio.listarTodosLasVendedor();
		modelo.addAttribute("lstV", lstV);

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

		List<Vendedor> lstV = Vservicio.listarTodosLasVendedor();
		modelo.addAttribute("lstV", lstV);
		
	

		modelo.addAttribute("ventas", servicio.obtenerVentaPorId(id));
		return "VentaCRUD/Editar_Venta";
	}
	
	@PostMapping("/ventas/{id}")
	public String actualizarVenta(@PathVariable Integer id, @ModelAttribute("venta") Venta venta, Model modelo) {

		Venta V = servicio.obtenerVentaPorId(id);
		
		V.setId_ventas(id);
		V.setFecha(venta.getFecha());
		V.setImpuesto(venta.getImpuesto());
		V.setValor_unitario(venta.getValor_unitario());
		//V.setId_Programacion_instalaciones_fk(venta.getId_Programacion_instalaciones_fk());
		V.setId_vendedor_fk(venta.getId_vendedor_fk());
		
		servicio.actualizarVenta(V);
		return "redirect:/ventas";
	}
	
	@GetMapping("/ventas/{id}")
	public String eliminarVenta(@PathVariable Integer id) {
		servicio.eliminarVenta(id);
		return "redirect:/ventas";
	}

	
}
