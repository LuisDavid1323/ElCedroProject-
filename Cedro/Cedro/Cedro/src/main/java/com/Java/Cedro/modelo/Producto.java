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
@Table(name="Productos")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	
	@Column(name="Nombre_producto ")
	private String Nombre_producto;
	
	@Column(name="Precio")
	private Double Precio;
	
	
	/*Producto_DetallePro*/
	
	
	/*Producto___DetalleCotizacion*/
	@OneToMany(mappedBy ="id_producto_fk")
    private List <Detalle_cotizacion>ListDetalle_cotizacion;
	
	
	
	//Getters and Setters


	public Integer getId_producto() {
		return id_producto;
	}


	public List<Detalle_cotizacion> getListDetalle_cotizacion() {
		return ListDetalle_cotizacion;
	}


	public void setListDetalle_cotizacion(List<Detalle_cotizacion> listDetalle_cotizacion) {
		ListDetalle_cotizacion = listDetalle_cotizacion;
	}



	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre_producto() {
		return Nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		Nombre_producto = nombre_producto;
	}


	public Double getPrecio() {
		return Precio;
	}


	public void setPrecio(Double precio) {
		Precio = precio;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
	

}
