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
@Table(name="Categorias_productos")
public class Categoria_producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categorias_productos;
	
	@Column(name="Nombre_categoria")
	private  String Nombre_categoria;
	
	
	/*Categoria_P____DetalleCotizacion*/
	@OneToMany(mappedBy ="id_Categoria_producto_fk")
    private List <Detalle_cotizacion>ListDetalle_cotizacion;

	
	//Getters and Setters

	public Integer getId_categorias_productos() {
		return id_categorias_productos;
	}


	public void setId_categorias_productos(Integer id_categorias_productos) {
		this.id_categorias_productos = id_categorias_productos;
	}


	public String getNombre_categoria() {
		return Nombre_categoria;
	}


	public void setNombre_categoria(String nombre_categoria) {
		Nombre_categoria = nombre_categoria;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	
	

}
