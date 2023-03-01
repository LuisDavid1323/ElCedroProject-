package com.Java.Cedro.servicioImpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.OrdenProduccionServicio;
import com.Java.Cedro.modelo.OrdenProduccion;
import com.Java.Cedro.modelo.Venta;
import com.Java.Cedro.modelo.enums.EstadoOrdenProduccionEnum;
import com.Java.Cedro.repositorio.OrdenProduccionRepositorio;
import com.Java.Cedro.repositorio.VentaRepositorio;


@Service
public class OrdenProduccionServicioImpl implements OrdenProduccionServicio{
	
	@Autowired
	private OrdenProduccionRepositorio repositorio;
	
	@Autowired
	private  VentaRepositorio ventaRepositorio;
	
	
	@Override
	public List<OrdenProduccion> listarTodosLasOrdenes() {
		return repositorio.findAll();
	}

	@Override
	public OrdenProduccion guardarOrden(OrdenProduccion orden) {
		return repositorio.save(orden);
	}

	@Override
	public OrdenProduccion obtenerOrdenPorId(Integer id_orden_de_produccion) {
		return repositorio.findById(id_orden_de_produccion).get();
	}

	@Override
	public OrdenProduccion actualizarOrden(OrdenProduccion orden) {
			OrdenProduccion guardado = this.repositorio.save(orden) ;
		if (guardado.getEstadoOrdenP().equals(EstadoOrdenProduccionEnum.Terminado)) {
			Venta  venta = new Venta();
			venta.setFecha(new Date().toString());
			venta.setId_ordenDeProduccion_fk(guardado);
			this.ventaRepositorio.save(venta);
		}
		return guardado;
	}

	@Override
	public void eliminarOrden(Integer id_orden_de_produccion) {
		repositorio.deleteById(id_orden_de_produccion);
		
	}

	@Override
	public void llenarVenta(Integer idOrdenProduccion) {
		
		
	}

}
