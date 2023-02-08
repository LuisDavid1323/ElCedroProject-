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
@Table(name="Estados_orden_produccion")
public class Estado_orden_produccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado_produccion;
	
	@Column(name="Nombre_estado_produccion")
	private  String Nombre_estado_produccion;
	
	/*EstadoOrdenPro_OrdenPro*/
	@OneToMany(mappedBy ="id_EstadoOrdenPro_fk")
	private List <orden_de_produccion>Listorden_de_produccion;
	
	
	//Getters and Setters
	
	
	public Integer getId_estado_produccion() {
		return id_estado_produccion;
	}

	public void setId_estado_produccion(Integer id_estado_produccion) {
		this.id_estado_produccion = id_estado_produccion;
	}

	public String getNombre_estado_produccion() {
		return Nombre_estado_produccion;
	}

	public void setNombre_estado_produccion(String nombre_estado_produccion) {
		Nombre_estado_produccion = nombre_estado_produccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<orden_de_produccion> getListorden_de_produccion() {
		return Listorden_de_produccion;
	}

	public void setListorden_de_produccion(List<orden_de_produccion> listorden_de_produccion) {
		Listorden_de_produccion = listorden_de_produccion;
	}


	
}
