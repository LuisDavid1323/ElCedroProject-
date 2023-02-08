package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.DetalleCotizacionServicio;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.repositorio.DetalleCotizacionRepositorio;

@Service
public class DetalleCotizacionServicioImpl implements DetalleCotizacionServicio{

	@Autowired
	private DetalleCotizacionRepositorio repositorio;

	@Override
	public List<Detalle_cotizacion> listarTodosLosDetalle() {
		return repositorio.findAll();
	}

	@Override
	public Detalle_cotizacion guardarDetalle(Detalle_cotizacion detalle_cotizacion) {
		return repositorio.save(detalle_cotizacion);
	}

	@Override
	public Detalle_cotizacion obtenerDetallePorId(Integer id_detalle_cotizacion) {
		return repositorio.findById(id_detalle_cotizacion).get();
	}

	@Override
	public Detalle_cotizacion actualizarDetalle(Detalle_cotizacion detalle_cotizacion) {
		return repositorio.save(detalle_cotizacion);
	}

	@Override
	public void eliminarDetalle(Integer id_detalle_cotizacion) {
		repositorio.deleteById(id_detalle_cotizacion);
		
	}

}
