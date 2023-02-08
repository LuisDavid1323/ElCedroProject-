package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.OrdenProServicio;
import com.Java.Cedro.modelo.orden_de_produccion;
import com.Java.Cedro.repositorio.OrdenProRepositorio;

@Service
public class OrdenProServicioImpl implements OrdenProServicio{
	
	@Autowired
	private OrdenProRepositorio repositorio;
	
	
	@Override
	public List<orden_de_produccion> listarTodasLasOrden() {
		return repositorio.findAll();
	}

	@Override
	public orden_de_produccion guardarOrden(orden_de_produccion ordenPro) {
		return repositorio.save(ordenPro);
	}

	@Override
	public orden_de_produccion obtenerOrdenPorId(Integer id_orden_de_produccion) {
		return repositorio.findById(id_orden_de_produccion).get();
	}

	@Override
	public orden_de_produccion actualizarOrden(orden_de_produccion ordenPro) {
		return repositorio.save(ordenPro);
	}

	@Override
	public void eliminarOrden(Integer id_orden_de_produccion) {
		repositorio.deleteById(id_orden_de_produccion);
		
	}

}
