package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.orden_de_produccion;


public interface OrdenProServicio {
	
	
	public List<orden_de_produccion> listarTodasLasOrden();

	public orden_de_produccion guardarOrden(orden_de_produccion ordenPro);

	public orden_de_produccion obtenerOrdenPorId(Integer id_orden_de_produccion);

	public orden_de_produccion actualizarOrden(orden_de_produccion ordenPro);

	public void eliminarOrden(Integer id_orden_de_produccion);

	
}
