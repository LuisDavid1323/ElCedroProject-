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
@Table(name="Color_madera")
public class Color_madera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_color_madera;
	
	@Column(name="Nombre_madera")
	private  String Nombre_madera;
	
	/*Tela_ColorMadera*/
	@ManyToOne
	@JoinColumn(name="id_maderas_fk", referencedColumnName = "id_maderas")
	private Madera id_maderas_fk;
	
	
	
	
	
	
	

}
