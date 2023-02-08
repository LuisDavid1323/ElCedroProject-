package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.Producto;


public interface ProductoServicio {
	
	public List<Producto> listarTodosLosProductos();

	public Producto guardarProducto(Producto producto);

	public Producto obtenerProductoPorId(Integer id_producto);

	public Producto actualizarProducto(Producto producto);

	public void eliminarProducto(Integer id_producto);

}
