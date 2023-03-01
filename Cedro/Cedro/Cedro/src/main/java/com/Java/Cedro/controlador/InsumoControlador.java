package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Java.Cedro.Servicio.CInsumoServicio;
import com.Java.Cedro.Servicio.InsumoServicio;
import com.Java.Cedro.modelo.Categoria_Insumo;
import com.Java.Cedro.modelo.Insumo;


@Controller
public class InsumoControlador {

	@Autowired
	private InsumoServicio servicio;

	@Autowired
	private CInsumoServicio Categoriaservicio;

	
	@GetMapping({ "insumos"})
	public String listarInsumos(Model modelo) {
		modelo.addAttribute("insumos", servicio.listarTodosLosInsumos());               
		
		return "InsumoCRUD/Insumo";
	}
	
	@GetMapping("/insumos/nuevo")
	public String mostrarFormularioDeRegistrarInsumo(Model modelo) {
		
		
		List<Categoria_Insumo> lstCategoria = Categoriaservicio.listarTodosCInsumo();              
		modelo.addAttribute("lstCategoria", lstCategoria);

		Insumo insumo = new Insumo();

		modelo.addAttribute("insumos", insumo);
		return "InsumoCRUD/Crear_Insumo";
	}
	
	@PostMapping("/insumos")
	public String guardarInsumo(@ModelAttribute("insumos") Insumo insumos) {
		servicio.guardarInsumo(insumos);
		return "redirect:/insumos";
	}
	
	@GetMapping("/insumos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
		
		List<Categoria_Insumo> lstCategoria = Categoriaservicio.listarTodosCInsumo();              
		modelo.addAttribute("lstCategoria", lstCategoria);
		
		modelo.addAttribute("insumos", servicio.obtenerInsumoPorId(id));
		return "InsumoCRUD/Editar_Insumo";
	}
	
	@PostMapping("/insumos/{id}")
	public String actualizarInsumo(@PathVariable Integer id, @ModelAttribute("insumos") Insumo insumos, Model modelo) {

		Insumo in = servicio.obtenerInsumoPorId(id);

		in.setId_insumo(id);
		in.setTel_distribuidor(insumos.getTel_distribuidor());
		in.setDistribuidor(insumos.getDistribuidor());
		in.setNombre(insumos.getNombre());
		in.setPrecio(insumos.getPrecio());
		in.setStock(insumos.getStock());
		in.setUnidad_de_medida(insumos.getUnidad_de_medida());
		in.setId_categoria_insumo_fk(insumos.getId_categoria_insumo_fk());
		
		servicio.actualizarInsumo(in);
		return "redirect:/insumos";
	}
	
	@GetMapping("/insumos/{id}")
	public String eliminarInsumo(@PathVariable Integer id) {
		servicio.eliminarInsumo(id);
		return "redirect:/insumos";
	}
	
	
}
