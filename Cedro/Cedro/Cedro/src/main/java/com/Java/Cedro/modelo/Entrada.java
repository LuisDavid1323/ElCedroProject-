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
@Table(name="Entradas")
public class Entrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_entrada;
	
	@Column(name="Fecha")
	private String Fecha;
	
	@Column(name="Cantidad")
	private Integer Cantidad;
	
	/*Entrada_Insumo*/

	@ManyToOne
	@JoinColumn(name="id_insumo_fk", referencedColumnName = "id_insumo")
	private Insumo id_insumo_fk;
	
	
	/*Getters and Setters*/
	
	public Integer getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(Integer id_entrada) {
		this.id_entrada = id_entrada;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public Insumo getId_insumo_fk() {
		return id_insumo_fk;
	}

	public void setId_insumo_fk(Insumo id_insumo_fk) {
		this.id_insumo_fk = id_insumo_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
}
