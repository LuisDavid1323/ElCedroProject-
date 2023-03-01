package com.Java.Cedro.DTO;

import java.math.BigInteger;

public class ProductoDTO {

	
	/*ProductoDTO*/
	
	private Integer id_producto;
	private String Nombre_productol;
	private BigInteger Precio;
	private Integer id_producto_fk;
	
	/*Constructor*/
	
	public ProductoDTO(Integer id_producto, String nombre_productol, BigInteger precio) {
		super();
		this.id_producto = id_producto;
		Nombre_productol = nombre_productol;
		Precio = precio;
	}
	
	/*Getters and Setters*/
	
	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_productol() {
		return Nombre_productol;
	}

	public void setNombre_productol(String nombre_productol) {
		Nombre_productol = nombre_productol;
	}

	public BigInteger getPrecio() {
		return Precio;
	}

	public void setPrecio(BigInteger precio) {
		Precio = precio;
	}

	public Integer getId_producto_fk() {
		return id_producto_fk;
	}

	public void setId_producto_fk(Integer id_producto_fk) {
		this.id_producto_fk = id_producto_fk;
	}

	
}
