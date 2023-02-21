package com.Java.Cedro.DTO;

public class DisenoDTO {

	
	/*Diseno*/
	private Integer id_diseño;
	private  String Nombre_d;
	
	/*Constructor*/
	
	public DisenoDTO(Integer id_diseño, String nombre_d) {
		super();
		this.id_diseño = id_diseño;
		Nombre_d = nombre_d;
	}
	
	/*Getters and Setters*/
	
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
	
	
	
	
	
}
