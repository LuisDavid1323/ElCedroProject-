package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.ProductoServicio;
import com.Java.Cedro.modelo.Producto;
import com.Java.Cedro.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
	
	@Autowired 
	private ProductoRepositorio repositorio; 
	
	
	@Override
	public List<Producto> listarTodosLosProductos() {
		return repositorio.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public Producto obtenerProductoPorId(Integer id_producto) {
		return repositorio.findById(id_producto).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id_producto) {
		repositorio.deleteById(id_producto);
		
	}

}
