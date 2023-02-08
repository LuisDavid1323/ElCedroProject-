package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Categoria_Insumo;




public interface CInsumoServicio {

	public List<Categoria_Insumo> listarTodosCInsumo();

	public Categoria_Insumo guardarCInsumo(Categoria_Insumo categoria_insumo);

	public Categoria_Insumo obtenerCInsumoPorId(Integer id_categoria_insumos);

	public Categoria_Insumo actualizarCInsumo(Categoria_Insumo categoria_insumo);

	public void eliminarCInsumo(Integer id_categoria_insumos);
}
