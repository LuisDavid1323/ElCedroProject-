package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.SalidaServicio;
import com.Java.Cedro.modelo.Insumo;
import com.Java.Cedro.modelo.Salida;
import com.Java.Cedro.repositorio.InsumoRepositorio;
import com.Java.Cedro.repositorio.SalidaRepositorio;

@Service
public class SalidaServicioImpl implements SalidaServicio{

	@Autowired
	private SalidaRepositorio salidaRepositorio;
	
	@Autowired
	private InsumoRepositorio insumoRepositorio;
	

	@Override
	public List<Salida> listarTodosLasSalidas() {
		return salidaRepositorio.findAll();
	}

	@Override
	public Salida guardarSalida(Salida salida) {
		Insumo insumo = this.insumoRepositorio.findById(salida.getId_insumo_fk().getId_insumo()).orElse(null);   
		insumo.setStock(insumo.getStock() - salida.getCantidad());
		insumoRepositorio.save(insumo);
		return salidaRepositorio.save(salida);
	}

	@Override
	public Salida obtenerSalidaPorId(Integer id_salida) {
		return salidaRepositorio.findById(id_salida).get();
	}

	@Override
	public Salida actualizarSalida(Salida salida) {
		return salidaRepositorio.save(salida);
	}

	@Override
	public void eliminarSalida(Integer id_salida) {
		salidaRepositorio.deleteById(id_salida);
		
	}


}
