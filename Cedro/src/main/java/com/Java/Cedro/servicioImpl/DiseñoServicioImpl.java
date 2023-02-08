package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.DiseñoServicio;
import com.Java.Cedro.modelo.Diseño;
import com.Java.Cedro.repositorio.DiseñoRepositorio;

@Service
public class DiseñoServicioImpl implements DiseñoServicio{
	
	@Autowired
	private DiseñoRepositorio repositorio;
	
	
	@Override
	public List<Diseño> listarTodosLosDiseños() {
		return repositorio.findAll();
	}

	@Override
	public Diseño guardarDiseño(Diseño Diseño) {
		return repositorio.save(Diseño);
	}

	@Override
	public Diseño obtenerDiseñoPorId(Integer id_diseño) {
		return repositorio.findById(id_diseño).get();
	}

	@Override
	public Diseño actualizarDiseño(Diseño Diseño) {
		return repositorio.save(Diseño);
	}

	@Override
	public void eliminarDiseño(Integer id_diseño) {
		repositorio.deleteById(id_diseño);
		
	}
	
	
}
