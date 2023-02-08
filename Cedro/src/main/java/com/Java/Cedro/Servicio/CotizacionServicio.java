package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Cotizacion;


public interface CotizacionServicio {
	
	public List<Cotizacion> listarTodosLasCotizaciones();
	
	public Cotizacion guardarCotizacion(Cotizacion cotizacion);
	
	public Cotizacion obtenerCotizacionPorId(Integer id_cotizacion);
	
	public Cotizacion actualizarCotizacion(Cotizacion cotizacion);
	
	public void eliminarCotizacion(Integer id_cotizacion);
}
