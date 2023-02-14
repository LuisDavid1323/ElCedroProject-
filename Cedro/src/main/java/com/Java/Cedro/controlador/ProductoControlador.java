package com.Java.Cedro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Java.Cedro.Servicio.ProductoServicio;
import com.Java.Cedro.modelo.Producto;


@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	
	@GetMapping("/products")
    public String getProducts(Model model) {
        List<Producto> products = productoServicio.listarTodosLosProductos();
        model.addAttribute("productos", products);
        return "cotizarC";
    }
	
	
	
	
	
	
	
}
