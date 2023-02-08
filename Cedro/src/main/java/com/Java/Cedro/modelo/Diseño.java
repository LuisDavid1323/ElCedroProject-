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
@Table(name="Diseños")
public class Diseño implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_diseño;
	
	@Column(name="Nombre_d")
	private  String Nombre_d;

	
	/*Diseño____DetalleCotizacion*/
	@OneToMany(mappedBy ="id_diseno_fk")
    private List <Detalle_cotizacion>ListDetalle_cotizacion;

    
    
    //Getters and Setters
    
	public Integer getId_diseño() {
		return id_diseño;
	}


	public void setId_diseño(Integer id_diseño) {
		this.id_diseño = id_diseño;
	}


	public String getNombre_d() {
		return Nombre_d;
	}


	public void setNombre_d(String nombre_d) {
		Nombre_d = nombre_d;
	}


	public List<Detalle_cotizacion> getListDetalle_cotizacion() {
		return ListDetalle_cotizacion;
	}


	public void setListDetalle_cotizacion(List<Detalle_cotizacion> listDetalle_cotizacion) {
		ListDetalle_cotizacion = listDetalle_cotizacion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    
   
    
    
	



}
