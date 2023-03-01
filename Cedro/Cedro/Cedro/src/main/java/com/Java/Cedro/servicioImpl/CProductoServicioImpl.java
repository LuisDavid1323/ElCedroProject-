package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.CProductoServicio;
import com.Java.Cedro.modelo.Categoria_producto;
import com.Java.Cedro.repositorio.CProductoRepositorio;

@Service
public class CProductoServicioImpl implements CProductoServicio{
	
	@Autowired
	private CProductoRepositorio repositorio;
	
	@Override
	public List<Categoria_producto> listarTodasLasCProducto() {
		return repositorio.findAll();
	}

	@Override
	public Categoria_producto guardarCProducto(Categoria_producto CProducto) {
		return repositorio.save(CProducto);
	}

	@Override
	public Categoria_producto obtenerCProductoPorId(Integer id_categorias_productos) {
		return repositorio.findById(id_categorias_productos).get();
	}

	@Override
	public Categoria_producto actualizarCProducto(Categoria_producto CProducto) {
		return repositorio.save(CProducto);
	}

	@Override
	public void eliminarCProducto(Integer id_categorias_productos) {
		repositorio.deleteById(id_categorias_productos);
		
	}

}
