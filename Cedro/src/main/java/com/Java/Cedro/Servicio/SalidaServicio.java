package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Salida;

public interface SalidaServicio {

	public List<Salida> listarTodosLasSalidas();
	
	public Salida guardarSalida(Salida salida);
	
	public Salida obtenerSalidaPorId(Integer id_salida);
	
	public Salida actualizarSalida(Salida salida);
	
	public void eliminarSalida(Integer id_salida);
}
