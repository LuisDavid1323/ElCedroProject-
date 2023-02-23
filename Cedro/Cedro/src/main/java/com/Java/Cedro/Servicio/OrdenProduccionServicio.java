package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.OrdenProduccion;


public interface OrdenProduccionServicio {
	
public List<OrdenProduccion> listarTodosLasOrdenes();
	
	public OrdenProduccion guardarOrden(OrdenProduccion orden);
	
	public OrdenProduccion obtenerOrdenPorId(Integer id_orden_de_produccion);
	
	public OrdenProduccion actualizarOrden(OrdenProduccion orden);
	
	public void eliminarOrden(Integer id_orden_de_produccion);
	
	/*DTO*/
	void llenarVenta(Integer idOrdenProduccion);
}
