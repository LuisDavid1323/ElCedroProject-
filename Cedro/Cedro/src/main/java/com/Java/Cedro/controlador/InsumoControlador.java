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
	private CInsumoServicio CIservicio;

	@GetMapping({ "/insumos" })
	public String listarInsumos(Model modelo) {
		modelo.addAttribute("insumos", servicio.listarTodosLosInsumos());
		return "InsumoCRUD/Insumo";
	}

	@GetMapping("/insumos/nuevo")
	public String mostrarFormularioDeRegistrtarInsumo(Model modelo) {
		List<Categoria_Insumo> lstC = CIservicio.listarTodosCInsumo();

		Insumo insumo = new Insumo();

		modelo.addAttribute("lstC", lstC);
		modelo.addAttribute("insumos", insumo);
		return "InsumoCRUD/Crear_Insumo";
	}

	@PostMapping("/insumos")
	public String guardarInsumo(@ModelAttribute("insumos") Insumo insumo) {
		servicio.guardarInsumo(insumo);
		return "redirect:/insumos";
	}

	@GetMapping("/insumos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {

		List<Categoria_Insumo> lstC = CIservicio.listarTodosCInsumo();
		modelo.addAttribute("lstC", lstC);

		modelo.addAttribute("insumos", servicio.obtenerInsumoPorId(id));
		return "InsumoCRUD/Editar_Insumo";
	}

	@PostMapping("/insumos/{id}")
	public String actualizarInsumo(@PathVariable Integer id, @ModelAttribute("insumo") Insumo insumo, Model modelo) {

		Insumo Ins = servicio.obtenerInsumoPorId(id);

	
		Ins.setNombre(insumo.getNombre());
		Ins.setId_categoria_insumo_fk(insumo.getId_categoria_insumo_fk());
		Ins.setUnidad_de_medida(insumo.getUnidad_de_medida());
		Ins.setPrecio(insumo.getPrecio());
		Ins.setStock(insumo.getStock());
		Ins.setDistribuidor(insumo.getDistribuidor());
		Ins.setTel_distribuidor(insumo.getTel_distribuidor());

		servicio.actualizarInsumo(Ins);
		return "redirect:/insumos";
	}

	@GetMapping("/insumos/{id}")
	public String eliminarInsumo(@PathVariable Integer id) {
		servicio.eliminarInsumo(id);
		return "redirect:/insumos";
	}

}
