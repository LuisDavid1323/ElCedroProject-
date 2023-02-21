package com.Java.Cedro.servicioImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.DTO.CotizacionDTO;
import com.Java.Cedro.Servicio.CotizacionServicio;
import com.Java.Cedro.modelo.Cotizacion;
import com.Java.Cedro.modelo.OrdenProduccion;
import com.Java.Cedro.modelo.enums.EstadoCotizacionEnum;
import com.Java.Cedro.modelo.enums.EstadoOrdenProduccionEnum;
import com.Java.Cedro.repositorio.CotizacionRepositorio;
import com.Java.Cedro.repositorio.OrdenProduccionRepositorio;


@Service
public class CotizacionServicioImpl implements CotizacionServicio{
	
	@Autowired
	private CotizacionRepositorio cotizacionRepositorio;
	
	@Autowired
	private OrdenProduccionRepositorio ordenProduccionRepositorio;
	

	
	@Override
	public List<Cotizacion> listarTodosLasCotizaciones() {
		return cotizacionRepositorio.findAll();
	}

	@Override
	public Cotizacion guardarCotizacion(Cotizacion cotizacion) {
		return cotizacionRepositorio.save(cotizacion);
	}

	@Override
	public Cotizacion obtenerCotizacionPorId(Integer id_cotizacion) {
		return cotizacionRepositorio.findById(id_cotizacion).get();
	}

	@Override
	public Cotizacion actualizarCotizacion(Cotizacion cotizacion) {
		return cotizacionRepositorio.save(cotizacion);
	}

	@Override
	public void eliminarCotizacion(Integer id_cotizacion) {
		cotizacionRepositorio.deleteById(id_cotizacion);
		
	}

	@Override
	public CotizacionDTO guardarCotizacionDTO(CotizacionDTO cotidto) {
		Cotizacion coti = new Cotizacion(cotidto.getId_detalle_cotizacion_fk());
		return null;
	}
	
	@Override
	public void pagarCotizacion(Integer idCotizacion) {
		/*Obtener la cotización*/
		Optional<Cotizacion> cotizacionOptional = this.cotizacionRepositorio.findById(idCotizacion);
		if(!cotizacionOptional.isPresent()) return;
		Cotizacion cotizacionDb = cotizacionOptional.get();
		cotizacionDb.setEstadoCotizacion(EstadoCotizacionEnum.PAGO);
		this.cotizacionRepositorio.save(cotizacionDb);

		/*Crear la orden de producción*/
		OrdenProduccion ordenProduccion = new OrdenProduccion();
		ordenProduccion.setFecha(new Date().toString());
		ordenProduccion.setId_cotizacion_fk(cotizacionDb);
		ordenProduccion.setEstadoOrdenP(EstadoOrdenProduccionEnum.EnProduccion);
		this.ordenProduccionRepositorio.save(ordenProduccion);
	}
	
}
