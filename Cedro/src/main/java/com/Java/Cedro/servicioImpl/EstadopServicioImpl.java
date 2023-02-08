package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.EstadopServicio;
import com.Java.Cedro.modelo.Estado_orden_produccion;
import com.Java.Cedro.repositorio.EstadopRepositorio;

@Service
public class EstadopServicioImpl implements EstadopServicio{
	
	@Autowired
	private EstadopRepositorio repositorio;
	
	
	@Override
	public List<Estado_orden_produccion> listarTodosLosEstadosp() {
		return repositorio.findAll();
	}

	@Override
	public Estado_orden_produccion guardarEstadop(Estado_orden_produccion Estado) {
		return repositorio.save(Estado);
	}

	@Override
	public Estado_orden_produccion obtenerEstadopPorId(Integer id_estado_produccion) {
		return repositorio.findById(id_estado_produccion).get();
	}

	@Override
	public Estado_orden_produccion actualizarEstadop(Estado_orden_produccion Estado) {
		return repositorio.save(Estado);
	}

	@Override
	public void eliminarEstadop(Integer id_estado_produccion) {
		repositorio.deleteById(id_estado_produccion);
		
	}

}
