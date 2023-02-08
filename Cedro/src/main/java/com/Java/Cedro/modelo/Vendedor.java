package com.Java.Cedro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="Vendedor")
public class Vendedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_vendedor;
	
	/*Vendedor__Usuario*/
	@ManyToOne
	@JoinColumn(name="id_usuario_fk", referencedColumnName = "id_usuario")
	private Usuario id_usuario_fk;
	
	/*Vendedor_Ventas*/
	@OneToMany(mappedBy ="id_vendedor_fk")
	private List <Venta>ListVenta;
	
	/*Getters and Setters*/
	
	public Integer getId_vendedor() {
		return id_vendedor;
	}

	public void setId_vendedor(Integer id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public Usuario getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Usuario id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
