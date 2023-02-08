package com.Java.Cedro.Servicio;

import java.util.List;

import com.Java.Cedro.modelo.Vendedor;



public interface VendedorServicio {
	
	public List<Vendedor> listarTodosLasVendedor();
	
	public Vendedor guardarVendedor(Vendedor vendedor);
	
	public Vendedor obtenerVendedorPorId(Integer id_vendedor);
	
	public Vendedor actualizarVendedor(Vendedor vendedor);
	
	public void eliminarVendedor(Integer id_vendedor);
}
