package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.OrdenProduccionServicio;
import com.Java.Cedro.modelo.OrdenProduccion;
import com.Java.Cedro.repositorio.OrdenProduccionRepositorio;


@Service
public class OrdenProduccionServicioImpl implements OrdenProduccionServicio{
	
	@Autowired
	private OrdenProduccionRepositorio repositorio;
	
	
	@Override
	public List<OrdenProduccion> listarTodosLasOrdenes() {
		return repositorio.findAll();
	}

	@Override
	public OrdenProduccion guardarOrden(OrdenProduccion orden) {
		return repositorio.save(orden);
	}

	@Override
	public OrdenProduccion obtenerOrdenPorId(Integer id_orden_de_produccion) {
		return repositorio.findById(id_orden_de_produccion).get();
	}

	@Override
	public OrdenProduccion actualizarOrden(OrdenProduccion orden) {
		return repositorio.save(orden);
	}

	@Override
	public void eliminarOrden(Integer id_orden_de_produccion) {
		repositorio.deleteById(id_orden_de_produccion);
		
	}

}
