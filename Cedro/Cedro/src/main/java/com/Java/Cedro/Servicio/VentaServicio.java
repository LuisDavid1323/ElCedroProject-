package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Venta;


public interface VentaServicio {
	
	
	public List<Venta> listarTodosLasVentas();
	
	public Venta guardarVenta(Venta Venta);
	
	public Venta obtenerVentaPorId(Integer id_ventas);
	
	public Venta actualizarVenta(Venta venta);
	
	public void eliminarVenta(Integer id_ventas);
}
