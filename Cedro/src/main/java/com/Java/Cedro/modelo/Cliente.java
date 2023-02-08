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




@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_clientes;
	
	/*Usuario_Cliente*/
	@ManyToOne
	@JoinColumn(name="id_usuario_fk", referencedColumnName = "id_usuario")
	private Usuario id_usuario_fk;
	
	@Column(name="Localidad")
	private String Localidad;
	
	@Column(name="Barrio")
	private String Barrio;
	
	
	/*Cotizacion___Cliente*/
	@OneToMany(mappedBy ="id_cliente_fk")
	private List <Cotizacion>ListCotizacion;
	
	/*Getters and Setters*/
	
	public Integer getId_clientes() {
		return id_clientes;
	}

	public void setId_clientes(Integer id_clientes) {
		this.id_clientes = id_clientes;
	}

	public Usuario getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Usuario id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getBarrio() {
		return Barrio;
	}

	public void setBarrio(String barrio) {
		Barrio = barrio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
