package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.EntradaServicio;
import com.Java.Cedro.modelo.Entrada;
import com.Java.Cedro.modelo.Insumo;
import com.Java.Cedro.repositorio.EntradaRepositorio;
import com.Java.Cedro.repositorio.InsumoRepositorio;

@Service
public class EntradaServicioImpl implements EntradaServicio{

	@Autowired
	private EntradaRepositorio repositorio;
	
	@Autowired
	private InsumoRepositorio insumoRepositorio;
	
	@Override
	public List<Entrada> listarTodosLasEntradas() {
		return repositorio.findAll();
	}

	@Override
	public Entrada guardarEntrada(Entrada entrada) {
		Insumo insumo = this.insumoRepositorio.findById(entrada.getId_insumo_fk().getId_insumo()).orElse(null);                             
		insumo.setStock(insumo.getStock() + entrada.getCantidad());
		insumoRepositorio.save(insumo);
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
