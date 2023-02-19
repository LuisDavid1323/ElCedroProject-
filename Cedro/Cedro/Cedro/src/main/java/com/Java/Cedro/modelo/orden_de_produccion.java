package com.Java.Cedro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Java.Cedro.modelo.enums.EstadoOrdenPEnum;






@Entity
@Table(name="orden_de_produccion")
public class orden_de_produccion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_orden_de_produccion;

	
	@Column(name="Fecha")
	private String Fecha;
	
	@Column(name="estado_ordenP")
	@Enumerated(EnumType.STRING)
	private EstadoOrdenPEnum EstadoOrdenP;
	
	/*OrdenPro_Venta*/
	@OneToMany(mappedBy ="id_ordenDeProduccion_fk")
	private List <Venta>ListVenta;
	
	
	
	/*Salida___OrdenPro*/
	@OneToMany(mappedBy ="id_orden_pro_fk")
	private List <Salida>ListSalida;
	
	
	
	/*OrdenP__Cotizacion*/
	@ManyToOne
	@JoinColumn(name="id_cotizacion_fk")
	private Cotizacion id_cotizacion_fk;
	
	
	//Getters and Setters
	
	public Integer getId_orden_de_produccion() {
		return id_orden_de_produccion;
	}

	public void setId_orden_de_produccion(Integer id_orden_de_produccion) {
		this.id_orden_de_produccion = id_orden_de_produccion;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		this.Fecha = fecha;
	}

	public List<Venta> getListVenta() {
		return ListVenta;
	}

	public void setListVenta(List<Venta> listVenta) {
		ListVenta = listVenta;
	}

	public List<Salida> getListSalida() {
		return ListSalida;
	}

	public void setListSalida(List<Salida> listSalida) {
		ListSalida = listSalida;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EstadoOrdenPEnum getEstadoOrdenP() {
		return EstadoOrdenP;
	}

	public void setEstadoOrdenP(EstadoOrdenPEnum estadoOrdenP) {
		EstadoOrdenP = estadoOrdenP;
	}

	public Cotizacion getId_cotizacion_fk() {
		return id_cotizacion_fk;
	}

	public void setId_cotizacion_fk(Cotizacion id_cotizacion_fk) {
		this.id_cotizacion_fk = id_cotizacion_fk;
	}

	

	
	
	
}
