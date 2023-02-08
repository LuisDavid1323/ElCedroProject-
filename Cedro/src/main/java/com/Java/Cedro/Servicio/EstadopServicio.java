package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Estado_orden_produccion;


public interface EstadopServicio {

public List<Estado_orden_produccion> listarTodosLosEstadosp();
	
	public Estado_orden_produccion guardarEstadop(Estado_orden_produccion Estado);
	
	public Estado_orden_produccion obtenerEstadopPorId(Integer id_estado_produccion);
	
	public Estado_orden_produccion actualizarEstadop(Estado_orden_produccion Estado);
	
	public void eliminarEstadop(Integer id_estado_produccion);
}
