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
@Table(name="Ventas")
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ventas;
	
	@Column(name="Fecha")
	private String Fecha;
	
	

	/*Ventas___Usuarios*/
	@ManyToOne
	private Usuario id_Usuarios_fk;
	
	
	/*OrdenPro_Venta*/
	@ManyToOne
	@JoinColumn(name="id_ordenDeProduccion_fk", referencedColumnName = "id_orden_de_produccion")
	private orden_de_produccion id_ordenDeProduccion_fk;
	
	


	//Getters and Setters
	
	public Integer getId_ventas() {
		return id_ventas;
	}



	public void setId_ventas(Integer id_ventas) {
		this.id_ventas = id_ventas;
	}



	public String getFecha() {
		return Fecha;
	}



	public void setFecha(String fecha) {
		Fecha = fecha;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Usuario getId_Usuarios_fk() {
		return id_Usuarios_fk;
	}



	public void setId_Usuarios_fk(Usuario id_Usuarios_fk) {
		this.id_Usuarios_fk = id_Usuarios_fk;
	}




	public orden_de_produccion getId_ordenDeProduccion_fk() {
		return id_ordenDeProduccion_fk;
	}



	public void setId_ordenDeProduccion_fk(orden_de_produccion id_ordenDeProduccion_fk) {
		this.id_ordenDeProduccion_fk = id_ordenDeProduccion_fk;
	}


	
	
	

}
