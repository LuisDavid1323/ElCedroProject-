package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.EstadocServicio;
import com.Java.Cedro.modelo.Estado_cotizacion;
import com.Java.Cedro.repositorio.EstadocRepositorio;

@Service
public class EstadocServicioImpl implements EstadocServicio{
	
	@Autowired
	private EstadocRepositorio repositorio;

	@Override
	public List<Estado_cotizacion> listarTodosLosEstado() {
		return repositorio.findAll();
	}

	@Override
	public Estado_cotizacion guardarEstado(Estado_cotizacion Estado_cotizacion) {
		return repositorio.save(Estado_cotizacion);
	}

	@Override
	public Estado_cotizacion obtenerEstadoPorId(Integer id_estado_cotizacion) {
		return repositorio.findById(id_estado_cotizacion).get();
	}

	@Override
	public Estado_cotizacion actualizarEstado(Estado_cotizacion Estado_cotizacion) {
		return repositorio.save(Estado_cotizacion);
	}

	@Override
	public void eliminarEstado(Integer id_estado_cotizacion) {
		repositorio.deleteById(id_estado_cotizacion);
		
	}
	
	
	
	

}
