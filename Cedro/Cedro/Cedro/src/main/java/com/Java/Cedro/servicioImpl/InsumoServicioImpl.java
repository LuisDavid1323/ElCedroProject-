package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.InsumoServicio;
import com.Java.Cedro.modelo.Insumo;
import com.Java.Cedro.repositorio.InsumoRepositorio;
import com.Java.Cedro.repositorio.SalidaRepositorio;

@Service
public class InsumoServicioImpl implements InsumoServicio{

	@Autowired
	private InsumoRepositorio repositorio;
	
	@Autowired
	private SalidaRepositorio salidaRepositorio;
	
	@Autowired
	private InsumoServicio insumoServicio;
	
	
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
	public Insumo actualizarInsumo(Insumo insumo) {
		return repositorio.save(insumo);
	}

	@Override
	public void eliminarInsumo(Integer id_insumo) {
		repositorio.deleteById(id_insumo);
		
	}


}
