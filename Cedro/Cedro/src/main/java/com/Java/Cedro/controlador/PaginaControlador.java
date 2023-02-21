package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Java.Cedro.DTO.DetalleCotizacionDTO;
import com.Java.Cedro.Servicio.CProductoServicio;
import com.Java.Cedro.Servicio.DisenoServicio;
import com.Java.Cedro.Servicio.MaderaServicio;
import com.Java.Cedro.Servicio.ProductoServicio;
import com.Java.Cedro.Servicio.TelaServicio;
import com.Java.Cedro.modelo.Categoria_producto;
import com.Java.Cedro.modelo.Diseno;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.modelo.Producto;
import com.Java.Cedro.modelo.Tela;

@Controller
public class PaginaControlador {

	@Autowired
	private ProductoServicio productoServicio;
	
	@Autowired
	private DisenoServicio disenoServicio;
	
	@Autowired
	private TelaServicio telaServicio;
	
	@Autowired
	private MaderaServicio maderaServicio;
	
	@Autowired
	private CProductoServicio categoriaServicio;
	
	@GetMapping("/index")
	public String index() {
		return "index";

	}

	@GetMapping("/cookies")
	public String cookies() {
		return "cookies";

	}

	@GetMapping("/cruds")
	public String cruds() {
		return "CRUDS";

	}

	@GetMapping("/cotizacion-cliente")
	public String cotizarC(Model model) {
		List<Producto> products = this.productoServicio.listarTodosLosProductos();
		List<Diseno> disign = this.disenoServicio.listarTodosLosDisenos();
		List<Tela> telas = this.telaServicio.listarTodasLasTelas();
		List<Madera> maderas = this.maderaServicio.listarTodasLasMadera();
		List<Categoria_producto> CategoriaP = this.categoriaServicio.listarTodasLasCProducto();  
		
		model.addAttribute("productos", products);
		model.addAttribute("d", disign);
		model.addAttribute("telas", telas);
		model.addAttribute("maderas", maderas);
		model.addAttribute("CategoriaP", CategoriaP);
		
		model.addAttribute("detalleCotizacion", new DetalleCotizacionDTO());
		
		System.out.println("Cantidad:");
		return "cotizarC";

	}
	
	
	
	/* UsersD */

	// @GetMapping("/administradores")
	// public String dashboard() {
	// return "dashboard";

	// }

	@GetMapping("/dashboardP")
	public String dashboardP() {
		return "dashboard-produccion";

	}

	@GetMapping("/dashboardV")
	public String dashboardV() {
		return "dashboard-ventas";

	}

	/* UsersD */

	// @GetMapping("/Iniciar")
	// public String Iniciar() {
	// return "/LogIn/Iniciar";

	// }

	// SignUp

	// @GetMapping("/Registrar")
	// public String mostrarFormularioDeRegistrtarNuevoU(Model modelo) {
	// Usuario usuario = new Usuario();
	// modelo.addAttribute("RegistrarU", usuario);
	// return "LogIn/Registrar";
	// }

	// @PostMapping("/Registrar")
	// public String guardarUsuario(@ModelAttribute("registrar") Usuario usuario) {
	// servicio.guardarUsuario(usuario);
	// return "redirect:/usuarios";
	// }

	// SignUp

	@GetMapping("/Recuperar")
	public String Recuperar() {
		return "/LogIn/Recuperar";

	}

	// Error

	@GetMapping("/error")
	public String Error() {
		return "error";

	}
}
