package com.Java.Cedro.Servicio;

import java.util.List;


import com.Java.Cedro.modelo.Detalle_cotizacion;

public interface DetalleCotiServicio {

	public List<Detalle_cotizacion> listarTodasLosDetalles_cotizacion();

	public Detalle_cotizacion guardarDetalle_cotizacion(Detalle_cotizacion Detalle_cotizacion);

	public Detalle_cotizacion obtenerDetalle_cotizacionPorId(Integer id_detalle_cotizacion);

	public Detalle_cotizacion actualizarDetalle_cotizacion(Detalle_cotizacion Detalle_cotizacion );

	public void eliminarDetalle_cotizacion(Integer id_detalle_cotizacion);
	
}
