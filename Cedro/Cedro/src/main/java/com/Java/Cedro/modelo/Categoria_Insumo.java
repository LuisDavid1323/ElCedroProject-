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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Categoria_insumos")
public class Categoria_Insumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria_insumos;
	
	@Column(name="Nombre_categoria_insumos")
	private  String Nombre_categoria_insumos;
	
	/*Insumo__Categoria_insumo*/
	@JsonIgnore
	@OneToMany(mappedBy ="id_categoria_insumo_fk")
	private List <Insumo>ListInsumo;
	
	
	/*Getters and Setters*/
	public Integer getId_categoria_insumos() {
		return id_categoria_insumos;
	}

	public void setId_categoria_insumos(Integer id_categoria_insumos) {
		this.id_categoria_insumos = id_categoria_insumos;
	}

	public String getNombre_categoria_insumos() {
		return Nombre_categoria_insumos;
	}

	public void setNombre_categoria_insumos(String nombre_categoria_insumos) {
		Nombre_categoria_insumos = nombre_categoria_insumos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
