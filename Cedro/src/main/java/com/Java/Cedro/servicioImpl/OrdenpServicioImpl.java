package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.OrdenpServicio;
import com.Java.Cedro.modelo.orden_de_produccion;
import com.Java.Cedro.repositorio.OrdenpRepositorio;

@Service
public class OrdenpServicioImpl implements OrdenpServicio{
	
	@Autowired
	private OrdenpRepositorio repositorio;
	
	
	@Override
	public List<orden_de_produccion> listarTodosLasOrdenes() {
		return repositorio.findAll();
	}

	@Override
	public orden_de_produccion guardarOrden(orden_de_produccion orden) {
		return repositorio.save(orden);
	}

	@Override
	public orden_de_produccion obtenerOrdenPorId(Integer id_orden_de_produccion) {
		return repositorio.findById(id_orden_de_produccion).get();
	}

	@Override
	public orden_de_produccion actualizarOrden(orden_de_produccion orden) {
		return repositorio.save(orden);
	}

	@Override
	public void eliminarOrden(Integer id_orden_de_produccion) {
		repositorio.deleteById(id_orden_de_produccion);
		
	}

}
