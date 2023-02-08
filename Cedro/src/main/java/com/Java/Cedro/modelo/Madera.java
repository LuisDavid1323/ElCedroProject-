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
@Table(name="Maderas")
public class Madera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_maderas;
	
	@Column(name="Nombre_madera")
	private String Nombre_madera;
	
	@Column(name="Precio")
	private String Precio;
	
	

	/*DetalleC_Maderas*/
	@OneToMany(mappedBy ="id_maderas_fk")
	private List <Detalle_cotizacion>ListDetalle_cotizacion;

	
	
	
	//Getters and Setters
	
	public Integer getId_maderas() {
		return Id_maderas;
	}



	public void setId_maderas(Integer id_maderas) {
		Id_maderas = id_maderas;
	}



	public String getNombre_madera() {
		return Nombre_madera;
	}



	public void setNombre_madera(String nombre_madera) {
		Nombre_madera = nombre_madera;
	}



	public String getPrecio() {
		return Precio;
	}



	public List<Detalle_cotizacion> getListDetalle_cotizacion() {
		return ListDetalle_cotizacion;
	}



	public void setListDetalle_cotizacion(List<Detalle_cotizacion> listDetalle_cotizacion) {
		ListDetalle_cotizacion = listDetalle_cotizacion;
	}



	public void setPrecio(String precio) {
		Precio = precio;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
