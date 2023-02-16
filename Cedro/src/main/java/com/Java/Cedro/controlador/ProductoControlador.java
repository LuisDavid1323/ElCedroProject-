package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.Servicio.ProductoServicio;
import com.Java.Cedro.modelo.Producto;

@Controller
public class ProductoControlador {

	@Autowired
	private ProductoServicio productoServicio;

	/* Listar productos */
	@GetMapping("/productos")
	public String getProducts(Model model) {
		List<Producto> products = productoServicio.listarTodosLosProductos();
		model.addAttribute("productos", products);
		return "cotizarC";
	}

	@GetMapping("/productosCRUD")
	public String getProductos(Model model) {
		List<Producto> products = productoServicio.listarTodosLosProductos();
		model.addAttribute("productos", products);
		return "ProductoCRUD/Productos";
	}
	/* Listar productos */

	@GetMapping("/productosCRUD/nuevo")
	public String mostrarFormularioDeRegistrtarProductos(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("productos", producto);

		return "ProductoCRUD/Crear_Productos";
	}

	@PostMapping("/productosCRUD")
	public String guardarUsuario(@ModelAttribute("producto") Producto producto) {
		productoServicio.guardarProducto(producto);
		return "redirect:/productosCRUD";
	}

}
