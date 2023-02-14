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
@Table(name="Ventas")
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ventas;
	
	@Column(name="Fecha")
	private String Fecha;
	
	@Column(name="Cita_instalacion")
	private String Cita_instalacion;
	
	@Column(name="Impuesto")
	private String Impuesto;
	
	@Column(name="Valor_Unitario")
	private String Valor_unitario;
	

	/*Ventas___Vendedor*/
	@ManyToOne
	@JoinColumn(name="id_vendedor_fk", referencedColumnName = "id_vendedor")
	private Vendedor id_vendedor_fk;
	
	
	
	
	

	
	/*OrdenPro_Venta*/
	@OneToMany(mappedBy ="id_venta_fk")
	private List <orden_de_produccion>Listorden_de_produccion;


	//Getters and Setters
	
	public Integer getId_ventas() {
		return id_ventas;
	}



	public void setId_ventas(Integer id_ventas) {
		this.id_ventas = id_ventas;
	}



	public String getFecha() {
		return Fecha;
	}



	public void setFecha(String fecha) {
		Fecha = fecha;
	}



	public String getImpuesto() {
		return Impuesto;
	}



	public void setImpuesto(String impuesto) {
		Impuesto = impuesto;
	}



	public String getValor_unitario() {
		return Valor_unitario;
	}



	public void setValor_unitario(String valor_unitario) {
		Valor_unitario = valor_unitario;
	}



	public Vendedor getId_vendedor_fk() {
		return id_vendedor_fk;
	}



	public void setId_vendedor_fk(Vendedor id_vendedor_fk) {
		this.id_vendedor_fk = id_vendedor_fk;
	}





	public List<orden_de_produccion> getListorden_de_produccion() {
		return Listorden_de_produccion;
	}



	public void setListorden_de_produccion(List<orden_de_produccion> listorden_de_produccion) {
		Listorden_de_produccion = listorden_de_produccion;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	



}
