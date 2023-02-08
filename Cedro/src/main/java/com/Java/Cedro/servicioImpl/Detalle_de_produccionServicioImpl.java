package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.Detalle_de_produccionServicio;
import com.Java.Cedro.modelo.Detalle_de_produccion;
import com.Java.Cedro.repositorio.Detalle_de_produccionRepositorio;

@Service
public class Detalle_de_produccionServicioImpl implements Detalle_de_produccionServicio{

	
	@Autowired
	private Detalle_de_produccionRepositorio repositorio;
	
	
	@Override
	public List<Detalle_de_produccion> listarTodosLosDetalle() {
		return repositorio.findAll();
	}

	@Override
	public Detalle_de_produccion guardarDetalle(Detalle_de_produccion detalle_de_produccion) {
		return repositorio.save(detalle_de_produccion);
	}

	@Override
	public Detalle_de_produccion obtenerDetallePorId(Integer id_detallePro) {
		return repositorio.findById(id_detallePro).get();
	}

	@Override
	public Detalle_de_produccion actualizarDetalle(Detalle_de_produccion detalle_de_produccion) {
		return repositorio.save(detalle_de_produccion);
	}

	@Override
	public void eliminarDetalle(Integer id_detallePro) {
		repositorio.deleteById(id_detallePro);
		
	}

}
