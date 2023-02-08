package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.VendedorServicio;
import com.Java.Cedro.modelo.Vendedor;
import com.Java.Cedro.repositorio.VendedorRepositorio;

@Service
public class VendedorServicioImpl implements VendedorServicio{
	
	@Autowired
	private VendedorRepositorio repositorio;
	
	
	@Override
	public List<Vendedor> listarTodosLasVendedor() {
		return repositorio.findAll();
	}

	@Override
	public Vendedor guardarVendedor(Vendedor vendedor) {
		return repositorio.save(vendedor);
	}

	@Override
	public Vendedor obtenerVendedorPorId(Integer id_vendedor) {
		return repositorio.findById(id_vendedor).get();
	}

	@Override
	public Vendedor actualizarVendedor(Vendedor vendedor) {
		return repositorio.save(vendedor);
	}

	@Override
	public void eliminarVendedor(Integer id_vendedor) {
		repositorio.deleteById(id_vendedor);
		
	}

}
