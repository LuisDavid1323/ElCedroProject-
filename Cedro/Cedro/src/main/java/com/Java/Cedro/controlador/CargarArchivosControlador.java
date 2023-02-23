package com.Java.Cedro.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Java.Cedro.Servicio.ICargarArchivosServicio;

@Controller
@RequestMapping("/prueba")
public class CargarArchivosControlador {

	@Autowired
	private ICargarArchivosServicio fileServicedao;

	// Woods
	@PostMapping("/upload")
	public String uploadFile(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileServicedao.save(files);
			return "redirect:/maderas?exito";
		} catch (Exception e) {
			return "redirect:/maderas?fallo";
		}
	}
	// Woods

	// Products
	@PostMapping("/subir")
	public String uploadFiles(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileServicedao.saved(files);
			return "redirect:/productosCRUD?exito";
		} catch (Exception e) {
			return "redirect:/productosCRUD?fallo";
		}
	}
	// Products

	// Insumos
	@PostMapping("/cargar")
	public String uploadCargar(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileServicedao.guardar(files);
			return "redirect:/insumos?exito";
		} catch (Exception e) {
			return "redirect:/insumos?fallo";
		}
	}
	// Insumos

	// Telas
	@PostMapping("/cargar1")
	public String uploadCargar1(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileServicedao.guardar1(files);
			return "redirect:/cloth?exito";
		} catch (Exception e) {
			return "redirect:/cloth?fallo";
		}
	}
	// Telas

	// Disenos
	@PostMapping("/cargar2")
	public String uploadCargar2(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileServicedao.guardar1(files);
			return "redirect:/disenos?exito";
		} catch (Exception e) {
			return "redirect:/disenos?fallo";
		}
	}
	// Disenos

}
