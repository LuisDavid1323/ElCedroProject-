package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.InsumoServicio;
import com.Java.Cedro.modelo.Insumo;
import com.Java.Cedro.repositorio.InsumoRepositorio;

@Service
public class InsumoServicioImpl implements InsumoServicio{

	@Autowired
	private InsumoRepositorio repositorio;
	
	
	@Override
	public List<Insumo> listarTodosLosInsumos() {
		return repositorio.findAll();
	}

	@Override
	public Insumo guardarInsumo(Insumo Insumo) {
		return repositorio.save(Insumo);
	}

	@Override
	public Insumo obtenerInsumoPorId(Integer id_insumo) {
		return repositorio.findById(id_insumo).get();
	}

	@Override
	public Insumo actualizarInsumo(Insumo usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public void eliminarInsumo(Integer id_insumo) {
		repositorio.deleteById(id_insumo);
		
	}

}
