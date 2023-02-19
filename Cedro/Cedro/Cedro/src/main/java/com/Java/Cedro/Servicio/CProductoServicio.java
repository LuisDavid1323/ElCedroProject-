package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Categoria_producto;

public interface CProductoServicio {

	public List<Categoria_producto> listarTodasLasCProducto();

	public Categoria_producto guardarCProducto(Categoria_producto CProducto);

	public Categoria_producto obtenerCProductoPorId(Integer id_categorias_productos);

	public Categoria_producto actualizarCProducto(Categoria_producto CProducto);

	public void eliminarCProducto(Integer id_categorias_productos);
}
