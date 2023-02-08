package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.Servicio.CProductoServicio;
import com.Java.Cedro.Servicio.DetalleCotiServicio;
import com.Java.Cedro.Servicio.DiseñoServicio;
import com.Java.Cedro.Servicio.MaderaServicio;
import com.Java.Cedro.Servicio.ProductoServicio;
import com.Java.Cedro.Servicio.TelaServicio;
import com.Java.Cedro.modelo.Categoria_producto;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.modelo.Diseño;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.modelo.Producto;
import com.Java.Cedro.modelo.Tela;

@Controller
public class DetalleCotiControlador {

	@Autowired
	private DetalleCotiServicio DCservicio;
	
	@Autowired
	private TelaServicio TServicio;
	
	@Autowired
	private MaderaServicio MServicio;
	
	@Autowired
	private DiseñoServicio DServicio;
	
	@Autowired
	private ProductoServicio PServicio;
	
	@Autowired
	private CProductoServicio CPServicio;
	
	@GetMapping({ "/DetalleCo"})
	public String listarDetalleCo(Model modelo) {
		modelo.addAttribute("DetalleCo", DCservicio.listarTodasLosDetalles_cotizacion());
		return "DetalleCoCRUD/DetalleCo";
	}  
	
	@GetMapping("/DetalleCo/nuevo")
	public String mostrarFormularioDeRegistrarDetalleCo(Model modelo) {
		
		List<Producto> lstP = PServicio.listarTodosLosProductos();
		modelo.addAttribute("lstP", lstP);
		
		List<Tela> lstTe = TServicio.listarTodasLasTelas();
		modelo.addAttribute("lstTe", lstTe);
		
		List<Madera> lstMa = MServicio.listarTodasLasMadera();
		modelo.addAttribute("lstMa", lstMa);
		
		List<Categoria_producto> lstCp = CPServicio.listarTodasLasCProducto();
		modelo.addAttribute("lstCp", lstCp);
		
		List<Diseño> lstD = DServicio.listarTodosLosDiseños();
		modelo.addAttribute("lstD", lstD);
		
		
		Detalle_cotizacion Detalle_cotizacion = new Detalle_cotizacion();

		
		modelo.addAttribute("DetalleCo", Detalle_cotizacion);
		return "Crear_DetalleCo";
	}
	
	@PostMapping("/DetalleCo")
	public String guardarDetalleCo(@ModelAttribute("DetalleCo") Detalle_cotizacion Detalle_cotizacion) {
		DCservicio.guardarDetalle_cotizacion(Detalle_cotizacion);
		return "redirect:/DetalleCo";
	}
	
	@GetMapping("/DetalleCo/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Producto> lstP = PServicio.listarTodosLosProductos();
		modelo.addAttribute("lstP", lstP);
		
		List<Tela> lstTe = TServicio.listarTodasLasTelas();
		modelo.addAttribute("lstTe", lstTe);
		
		List<Madera> lstMa = MServicio.listarTodasLasMadera();
		modelo.addAttribute("lstMa", lstMa);
		
		List<Categoria_producto> lstCp = CPServicio.listarTodasLasCProducto();
		modelo.addAttribute("lstCp", lstCp);
		
		List<Diseño> lstD = DServicio.listarTodosLosDiseños();
		modelo.addAttribute("lstD", lstD);

		modelo.addAttribute("DetalleCo", DCservicio.obtenerDetalle_cotizacionPorId(id) );
		return "DetalleCoCRUD/Editar_EditarDetalleCo";
	}
	
	@PostMapping("/DetalleCo/{id}")
	public String actualizarDetalleCo(@PathVariable Integer id, @ModelAttribute("DetalleCo") Detalle_cotizacion Detalle_cotizacion, Model modelo) {

		Detalle_cotizacion Dc = DCservicio.obtenerDetalle_cotizacionPorId(id);
		
		Dc.setId_detalle_cotizacion(id);
		Dc.setCantidad(Detalle_cotizacion.getCantidad());
		Dc.setId_producto_fk(Detalle_cotizacion.getId_producto_fk());
		Dc.setId_diseno_fk(Detalle_cotizacion.getId_diseno_fk());
		Dc.setId_maderas_fk(Detalle_cotizacion.getId_maderas_fk());
		Dc.setId_Categoria_producto_fk(Detalle_cotizacion.getId_Categoria_producto_fk());
		Dc.setId_tela_fk(Detalle_cotizacion.getId_tela_fk());
		
		
		DCservicio.actualizarDetalle_cotizacion(Dc);
		return "redirect:/DetalleCo";
	}
	
	@GetMapping("/DetalleCo/{id}")
	public String eliminarDetalleCo(@PathVariable Integer id) {
		DCservicio.eliminarDetalle_cotizacion(id);
		return "redirect:/DetalleCo";
	}
}
