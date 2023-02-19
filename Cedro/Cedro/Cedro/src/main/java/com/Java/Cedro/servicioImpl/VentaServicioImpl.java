package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.VentaServicio;
import com.Java.Cedro.modelo.Venta;
import com.Java.Cedro.repositorio.VentaRepositorio;

@Service
public class VentaServicioImpl implements VentaServicio{
	
	@Autowired
	private VentaRepositorio repositorio;
	
	
	@Override
	public List<Venta> listarTodosLasVentas() {
		return repositorio.findAll();
	}

	@Override
	public Venta guardarVenta(Venta Venta) {
		return repositorio.save(Venta);
	}

	@Override
	public Venta obtenerVentaPorId(Integer id_ventas) {
		return repositorio.findById(id_ventas).get();
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		return repositorio.save(venta);
	}

	@Override
	public void eliminarVenta(Integer id_ventas) {
		repositorio.deleteById(id_ventas);
		
	}

}
