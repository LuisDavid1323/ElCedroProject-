package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.DetalleCotiServicio;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.repositorio.DetalleCotiRepositorio;

@Service
public class DetalleCotiServicioImpl implements DetalleCotiServicio {

	@Autowired
	private DetalleCotiRepositorio repositorio;

	@Override
	public List<Detalle_cotizacion> listarTodasLosDetalles_cotizacion() {
		return repositorio.findAll();
	}

	@Override
	public Detalle_cotizacion guardarDetalle_cotizacion(Detalle_cotizacion Detalle_cotizacion) {
		
		return repositorio.save(Detalle_cotizacion);
	}

	@Override
	public Detalle_cotizacion obtenerDetalle_cotizacionPorId(Integer id_detalle_cotizacion) {
		return repositorio.findById(id_detalle_cotizacion).get();
	}

	@Override
	public Detalle_cotizacion actualizarDetalle_cotizacion(Detalle_cotizacion Detalle_cotizacion) {
		return repositorio.save(Detalle_cotizacion);
	}

	@Override
	public void eliminarDetalle_cotizacion(Integer id_detalle_cotizacion) {
		repositorio.deleteById(id_detalle_cotizacion);
	}
	
	
	

}
