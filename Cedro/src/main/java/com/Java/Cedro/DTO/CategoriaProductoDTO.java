package com.Java.Cedro.DTO;

public class CategoriaProductoDTO {
	
	/*CategoriaProducto*/
	private Integer id_categorias_productos;
	private  String Nombre_categoria;
	
	/*Constructor*/
	public CategoriaProductoDTO(Integer id_categorias_productos, String nombre_categoria) {
		super();
		this.id_categorias_productos = id_categorias_productos;
		Nombre_categoria = nombre_categoria;
	}
	
	
	/*Getters and Setters*/
	
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
	
	
	
	
}
