package com.Java.Cedro.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="Pedidos")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	

	@Column(name="Fecha")
	private String Fecha;
	
	
	
	
	/*OrdenPro_Venta*/
	@OneToMany(mappedBy ="id_pedido_fk")
	private List <Venta>ListVenta;
	
	
	/*Cotizacion_Pedido*/
	@ManyToOne
	@JoinColumn(name="id_cotizacion_fk", referencedColumnName = "id_cotizacion")
	private Cotizacion id_cotizacion_fk;

	
	
	//Getters And Setters
	
	public Integer getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}


	public String getFecha() {
		return Fecha;
	}


	public void setFecha(String fecha) {
		Fecha = fecha;
	}



	public Cotizacion getId_cotizacion_fk() {
		return id_cotizacion_fk;
	}


	public void setId_cotizacion_fk(Cotizacion id_cotizacion_fk) {
		this.id_cotizacion_fk = id_cotizacion_fk;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	


}
