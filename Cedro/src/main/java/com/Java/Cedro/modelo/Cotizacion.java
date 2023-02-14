package com.Java.Cedro.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name="Cotizacion")
public class Cotizacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cotizacion;
	
	@Column(name="fecha")
	private String fecha;
	
	
	
	
	/*Cotizacion_EstadosCoti*/
	@ManyToOne
	@JoinColumn(name="id_estado_cotizacion_fk", referencedColumnName = "id_estado_cotizacion")
	private Estado_cotizacion id_estado_cotizacion_fk;
	
	
	
	/*DetalleC_Cotizacion*/

	@ManyToOne
	@JoinColumn(name="id_detalle_cotizacion_fk", referencedColumnName = "id_detalle_cotizacion")
	private Detalle_cotizacion id_detalle_cotizacion_fk;
	
	
	/*Cotizacion___Cliente*/
	@ManyToOne
	@JoinColumn(name="id_cliente_fk", referencedColumnName = "id_clientes")
	private Cliente id_cliente_fk;

	
	
	//Getters and Setters
	
	public Integer getId_cotizacion() {
		return id_cotizacion;
	}


	public void setId_cotizacion(Integer id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Estado_cotizacion getId_estado_cotizacion_fk() {
		return id_estado_cotizacion_fk;
	}


	public void setId_estado_cotizacion_fk(Estado_cotizacion id_estado_cotizacion_fk) {
		this.id_estado_cotizacion_fk = id_estado_cotizacion_fk;
	}


	public Detalle_cotizacion getId_detalle_cotizacion_fk() {
		return id_detalle_cotizacion_fk;
	}


	public void setId_detalle_cotizacion_fk(Detalle_cotizacion id_detalle_cotizacion_fk) {
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}


	public Cliente getId_cliente_fk() {
		return id_cliente_fk;
	}


	public void setId_cliente_fk(Cliente id_cliente_fk) {
		this.id_cliente_fk = id_cliente_fk;
	}

	
	/*Constructor*/
	public Cotizacion(Detalle_cotizacion id_detalle_cotizacion_fk) {
		super();
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}


	

	
	
	

	
	
	

	

	
	
	

}
