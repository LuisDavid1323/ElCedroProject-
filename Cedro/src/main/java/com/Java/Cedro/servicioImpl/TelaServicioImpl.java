package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.TelaServicio;
import com.Java.Cedro.modelo.Tela;
import com.Java.Cedro.repositorio.TelaRepositorio;

@Service
public class TelaServicioImpl implements TelaServicio{
	
	@Autowired
	private TelaRepositorio repositorio;
	
	@Override
	public List<Tela> listarTodasLasTelas() {
		return repositorio.findAll();
	}

	@Override
	public Tela guardarTela(Tela tela) {
		return repositorio.save(tela);
	}

	@Override
	public Tela obtenerTelaPorId(Integer id_telas) {
		return repositorio.findById(id_telas).get();
	}

	@Override
	public Tela actualizarTela(Tela tela) {
		return repositorio.save(tela);
	}

	@Override
	public void eliminarTela(Integer id_telas) {
		repositorio.deleteById(id_telas);
		
	}

}
