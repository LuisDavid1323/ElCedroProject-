package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.Detalle_de_produccion;


public interface Detalle_de_produccionServicio {
	
	
	public List<Detalle_de_produccion> listarTodosLosDetalle();
	
	public Detalle_de_produccion guardarDetalle(Detalle_de_produccion detalle_de_produccion);
	
	public Detalle_de_produccion obtenerDetallePorId(Integer id_detallePro);
	
	public Detalle_de_produccion actualizarDetalle(Detalle_de_produccion detalle_de_produccion);
	
	public void eliminarDetalle(Integer id_detallePro);
}
