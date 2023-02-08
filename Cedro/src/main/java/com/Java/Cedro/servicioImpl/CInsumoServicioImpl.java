package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.CInsumoServicio;
import com.Java.Cedro.modelo.Categoria_Insumo;
import com.Java.Cedro.repositorio.CInsumoRepositorio;

@Service
public class CInsumoServicioImpl implements CInsumoServicio{

	@Autowired
	private CInsumoRepositorio repositorio;
	
	@Override
	public List<Categoria_Insumo> listarTodosCInsumo() {
		return repositorio.findAll();
	}

	@Override
	public Categoria_Insumo guardarCInsumo(Categoria_Insumo categoria_insumo) {
		return repositorio.save(categoria_insumo);
	}

	@Override
	public Categoria_Insumo obtenerCInsumoPorId(Integer id_categoria_insumos) {
		return repositorio.findById(id_categoria_insumos).get();
	}

	@Override
	public Categoria_Insumo actualizarCInsumo(Categoria_Insumo categoria_insumo) {
		return repositorio.save(categoria_insumo);
	}

	@Override
	public void eliminarCInsumo(Integer id_categoria_insumos) {
		repositorio.deleteById(id_categoria_insumos);
		
	}

}
