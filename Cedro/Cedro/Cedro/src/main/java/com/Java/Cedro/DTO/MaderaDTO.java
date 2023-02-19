package com.Java.Cedro.DTO;

public class MaderaDTO {

	/*Madera*/
	private Integer Id_maderas;
	private String Nombre_madera;
	private String Precio;
	private Integer id_maderas_fk;
	
	/*Constructor*/
	public MaderaDTO(Integer id_maderas, String nombre_madera, String precio, Integer id_maderas_fk) {
		super();
		Id_maderas = id_maderas;
		Nombre_madera = nombre_madera;
		Precio = precio;
		this.id_maderas_fk = id_maderas_fk;
	}
	
	
	/*Getters and Setters*/
	
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

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public Integer getId_maderas_fk() {
		return id_maderas_fk;
	}

	public void setId_maderas_fk(Integer id_maderas_fk) {
		this.id_maderas_fk = id_maderas_fk;
	}
	
	
	
	
	
}
