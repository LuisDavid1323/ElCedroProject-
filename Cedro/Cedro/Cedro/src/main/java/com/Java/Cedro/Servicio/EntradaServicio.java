package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.Entrada;


public interface EntradaServicio {

	
	public List<Entrada> listarTodosLasEntradas();
	
	public Entrada guardarEntrada(Entrada entrada);
	
	public Entrada obtenerEntradaPorId(Integer id_entrada);
	
	public Entrada actualizarEntrada(Entrada entrada);
	
	public void eliminarEntrada(Integer id_entrada);
}
