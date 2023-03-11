package com.Java.Cedro.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;






@Entity
@Table(name="Insumos")
public class Insumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_insumo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Unidad_de_medida")
	private String unidad_de_medida;
	
	@Column(name="Precio")
	private String precio;
	
	@Column(name="Stock")
	@Size(min = 1)
	private Integer stock;
	
	@Column(name="Distribuidor")
	private String distribuidor;
	
	@Column(name="Tel_distribuidor")
	private String Tel_distribuidor;
	
	/*Insumo__Categoria_insumo*/
	@ManyToOne
	@JoinColumn(name="id_categoria_insumo_fk", referencedColumnName = "id_categoria_insumos")
	private Categoria_Insumo id_categoria_insumo_fk;
	
	  /*Insumo_Entrada*/
		@OneToMany(mappedBy ="id_insumo_fk")
		private List <Entrada>ListEntrada;
		
		/*Insumo_Salida*/
		@OneToMany(mappedBy ="id_insumo_fk")
		private List <Salida>ListSalida;
		
	
	/*Setters and Getters*/
	
	public Integer getId_insumo() {
		return id_insumo;
	}

	public void setId_insumo(Integer id_insumo) {
		this.id_insumo = id_insumo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad_de_medida() {
		return unidad_de_medida;
	}

	public void setUnidad_de_medida(String unidad_de_medida) {
		this.unidad_de_medida = unidad_de_medida;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getTel_distribuidor() {
		return Tel_distribuidor;
	}

	public void setTel_distribuidor(String tel_distribuidor) {
		Tel_distribuidor = tel_distribuidor;
	}

	public Categoria_Insumo getId_categoria_insumo_fk() {
		return id_categoria_insumo_fk;
	}

	public void setId_categoria_insumo_fk(Categoria_Insumo id_categoria_insumo_fk) {
		this.id_categoria_insumo_fk = id_categoria_insumo_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
