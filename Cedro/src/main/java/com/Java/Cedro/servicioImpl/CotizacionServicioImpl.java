package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.CotizacionServicio;
import com.Java.Cedro.modelo.Cotizacion;
import com.Java.Cedro.repositorio.CotizacionRepositorio;


@Service
public class CotizacionServicioImpl implements CotizacionServicio{
	
	@Autowired
	private CotizacionRepositorio repositorio;
	
	
	@Override
	public List<Cotizacion> listarTodosLasCotizaciones() {
		return repositorio.findAll();
	}

	@Override
	public Cotizacion guardarCotizacion(Cotizacion cotizacion) {
		return repositorio.save(cotizacion);
	}

	@Override
	public Cotizacion obtenerCotizacionPorId(Integer id_cotizacion) {
		return repositorio.findById(id_cotizacion).get();
	}

	@Override
	public Cotizacion actualizarCotizacion(Cotizacion cotizacion) {
		return repositorio.save(cotizacion);
	}

	@Override
	public void eliminarCotizacion(Integer id_cotizacion) {
		repositorio.deleteById(id_cotizacion);
		
	}

}
