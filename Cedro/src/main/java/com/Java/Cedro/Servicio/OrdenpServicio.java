package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.orden_de_produccion;


public interface OrdenpServicio {
	
public List<orden_de_produccion> listarTodosLasOrdenes();
	
	public orden_de_produccion guardarOrden(orden_de_produccion orden);
	
	public orden_de_produccion obtenerOrdenPorId(Integer id_orden_de_produccion);
	
	public orden_de_produccion actualizarOrden(orden_de_produccion orden);
	
	public void eliminarOrden(Integer id_orden_de_produccion);
}
