package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Detalle_cotizacion;

public interface DetalleCotizacionServicio {

	public List<Detalle_cotizacion> listarTodosLosDetalle();
	
	public Detalle_cotizacion guardarDetalle(Detalle_cotizacion detalle_cotizacion);
	
	public Detalle_cotizacion obtenerDetallePorId(Integer id_detalle_cotizacion);
	
	public Detalle_cotizacion actualizarDetalle(Detalle_cotizacion detalle_cotizacion);
	
	public void eliminarDetalle(Integer id_detalle_cotizacion);
}
