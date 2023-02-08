package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.EntradaServicio;
import com.Java.Cedro.modelo.Entrada;
import com.Java.Cedro.repositorio.EntradaRepositorio;

@Service
public class EntradaServicioImpl implements EntradaServicio{

	@Autowired
	private EntradaRepositorio repositorio;
	
	
	@Override
	public List<Entrada> listarTodosLasEntradas() {
		return repositorio.findAll();
	}

	@Override
	public Entrada guardarEntrada(Entrada entrada) {
		return repositorio.save(entrada);
	}

	@Override
	public Entrada obtenerEntradaPorId(Integer id_entrada) {
		return repositorio.findById(id_entrada).get();
	}

	@Override
	public Entrada actualizarEntrada(Entrada entrada) {
		return repositorio.save(entrada);
	}

	@Override
	public void eliminarEntrada(Integer id_entrada) {
		repositorio.deleteById(id_entrada);
		
	}

}
