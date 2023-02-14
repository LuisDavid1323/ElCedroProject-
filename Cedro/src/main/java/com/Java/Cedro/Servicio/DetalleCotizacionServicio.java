package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.DTO.DetalleCotizacionDTO;
import com.Java.Cedro.modelo.Detalle_cotizacion;

public interface DetalleCotizacionServicio {

	public List<Detalle_cotizacion> listarTodosLosDetalle();
	
	public Detalle_cotizacion guardarDetalle(DetalleCotizacionDTO detalle_cotizacion);
	
	public Detalle_cotizacion obtenerDetallePorId(Integer id_detalle_cotizacion);
	
	public Detalle_cotizacion actualizarDetalle(Integer id_detalle_cotizacion,DetalleCotizacionDTO detalleDto);
	
	public void eliminarDetalle(Integer id_detalle_cotizacion);
	
}
