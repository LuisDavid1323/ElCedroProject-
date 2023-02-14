package com.Java.Cedro.DTO;


import com.Java.Cedro.modelo.Detalle_cotizacion;



public class CotizacionDTO{

	/*Cotizacion*/
	private Detalle_cotizacion id_detalle_cotizacion_fk;
	
	/*Constructor*/
	public CotizacionDTO(Detalle_cotizacion id_detalle_cotizacion_fk) {
		super();
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}
	
	
	/*Getters and Setters*/
	
	

	public Detalle_cotizacion getId_detalle_cotizacion_fk() {
		return id_detalle_cotizacion_fk;
	}

	public void setId_detalle_cotizacion_fk(Detalle_cotizacion id_detalle_cotizacion_fk) {
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}


	
	
	
	
	
	
	
	
}
