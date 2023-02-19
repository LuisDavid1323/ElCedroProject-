package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.SalidaServicio;
import com.Java.Cedro.modelo.Salida;
import com.Java.Cedro.repositorio.SalidaRepositorio;

@Service
public class SalidaServicioImpl implements SalidaServicio{

	@Autowired
	private SalidaRepositorio repositorio;
	
	
	@Override
	public List<Salida> listarTodosLasSalidas() {
		return repositorio.findAll();
	}

	@Override
	public Salida guardarSalida(Salida salida) {
		return repositorio.save(salida);
	}

	@Override
	public Salida obtenerSalidaPorId(Integer id_salida) {
		return repositorio.findById(id_salida).get();
	}

	@Override
	public Salida actualizarSalida(Salida salida) {
		return repositorio.save(salida);
	}

	@Override
	public void eliminarSalida(Integer id_salida) {
		repositorio.deleteById(id_salida);
		
	}

}
