package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.DisenoServicio;

import com.Java.Cedro.modelo.Diseno;
import com.Java.Cedro.repositorio.DisenoRepositorio;


@Service
public class DisenoServicioImpl implements DisenoServicio{
	
	@Autowired
	private DisenoRepositorio repositorio;
	
	
	@Override
	public List<Diseno> listarTodosLosDisenos() {
		return repositorio.findAll();
	}

	@Override
	public Diseno guardarDiseno(Diseno Diseno) {
		return repositorio.save(Diseno);
	}

	@Override
	public Diseno obtenerDisenoPorId(Integer id_diseno) {
		return repositorio.findById(id_diseno).get();
	}

	@Override
	public Diseno actualizarDiseno(Diseno Diseno) {
		return repositorio.save(Diseno);
	}

	@Override
	public void eliminarDiseno(Integer id_diseno) {
		repositorio.deleteById(id_diseno);
		
	}
	
	
}
