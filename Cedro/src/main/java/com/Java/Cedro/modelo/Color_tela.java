package com.Java.Cedro.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Color_telas")
public class Color_tela implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_color_telas;
	
	@Column(name="Nombre")
	private  String Nombre_color;
	
	
	/*Tela_ColorT*/
	@ManyToOne
	@JoinColumn(name="id_telas_fk", referencedColumnName = "id_telas")
	private Tela id_telas_fk;

	
	//Getters and Setters
	
	public Integer getId_color_telas() {
		return id_color_telas;
	}


	public void setId_color_telas(Integer id_color_telas) {
		this.id_color_telas = id_color_telas;
	}


	public String getNombre_color() {
		return Nombre_color;
	}


	public void setNombre_color(String nombre_color) {
		Nombre_color = nombre_color;
	}


	public Tela getId_telas_fk() {
		return id_telas_fk;
	}


	public void setId_telas_fk(Tela id_telas_fk) {
		this.id_telas_fk = id_telas_fk;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
