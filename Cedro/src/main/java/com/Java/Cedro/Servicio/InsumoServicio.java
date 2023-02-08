package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Insumo;

public interface InsumoServicio {

	public List<Insumo> listarTodosLosInsumos();
	
	public Insumo guardarInsumo(Insumo Insumo);
	
	public Insumo obtenerInsumoPorId(Integer id_insumo);
	
	public Insumo actualizarInsumo(Insumo usuario);
	
	public void eliminarInsumo(Integer id_insumo);
}
