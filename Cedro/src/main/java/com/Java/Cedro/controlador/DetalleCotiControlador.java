package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.DTO.DetalleCotizacionDTO;
import com.Java.Cedro.Servicio.CProductoServicio;
import com.Java.Cedro.Servicio.DetalleCotizacionServicio;
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
	private DetalleCotizacionServicio DCservicio;
	
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
		modelo.addAttribute("DetalleCo", DCservicio.listarTodosLosDetalle());
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
	public String guardarDetalleCo(@ModelAttribute("DetalleCo") DetalleCotizacionDTO Detalle_cotizacion) {
		DCservicio.guardarDetalle(Detalle_cotizacion);
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

		modelo.addAttribute("DetalleCo", DCservicio.obtenerDetallePorId(id) );
		return "DetalleCoCRUD/Editar_EditarDetalleCo";
	}
	
	@PostMapping("/DetalleCo/{id}")
	public String actualizarDetalleCo(@PathVariable Integer id, @ModelAttribute("DetalleCo") DetalleCotizacionDTO Detalle_cotizacion, Model modelo) {
		
		DCservicio.actualizarDetalle(id, Detalle_cotizacion);
		return "redirect:/DetalleCo";
	}
	
	@GetMapping("/DetalleCo/{id}")
	public String eliminarDetalleCo(@PathVariable Integer id) {
		DCservicio.eliminarDetalle(id);
		return "redirect:/DetalleCo";
	}
}
