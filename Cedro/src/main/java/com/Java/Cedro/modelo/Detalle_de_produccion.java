package com.Java.Cedro.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DetallePro")
public class Detalle_de_produccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detallePro;
	
	@Column(name="Cantidad")
	private int Cantidad;
	
	@Column(name="Alto")
	private int Alto;
	
	@Column(name="Ancho")
	private int Ancho;
	
	@Column(name="Fondo")
	private int Fondo;
	
	
	
	/*OrdenPro_DetallePro*/
	@OneToMany(mappedBy ="id_detallePro_fk")
	private List <orden_de_produccion>Listorden_de_produccion;
	
	
	
	
	
	
	//Getters and Setters
	
	public Integer getId_detallePro() {
		return id_detallePro;
	}

	public void setId_detallePro(Integer id_detallePro) {
		this.id_detallePro = id_detallePro;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public int getAlto() {
		return Alto;
	}

	public void setAlto(int alto) {
		Alto = alto;
	}

	public int getAncho() {
		return Ancho;
	}

	public void setAncho(int ancho) {
		Ancho = ancho;
	}

	public int getFondo() {
		return Fondo;
	}

	public void setFondo(int fondo) {
		Fondo = fondo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
