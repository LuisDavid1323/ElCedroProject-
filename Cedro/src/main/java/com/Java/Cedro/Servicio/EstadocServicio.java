package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.Estado_cotizacion;


public interface EstadocServicio {
	
public List<Estado_cotizacion> listarTodosLosEstado();
	
	public Estado_cotizacion guardarEstado(Estado_cotizacion Estado_cotizacion);
	
	public Estado_cotizacion obtenerEstadoPorId(Integer id_estado_cotizacion);
	
	public Estado_cotizacion actualizarEstado(Estado_cotizacion Estado_cotizacion);
	
	public void eliminarEstado(Integer id_estado_cotizacion);
}
