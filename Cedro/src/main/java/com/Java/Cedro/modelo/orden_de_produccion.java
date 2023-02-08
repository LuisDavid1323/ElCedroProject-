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
	
	/*OrdenPro_DetallePro*/
	@ManyToOne
	@JoinColumn(name="id_detallePro_fk", referencedColumnName = "id_detallePro")
	private Detalle_de_produccion id_detallePro_fk;
	
	/*OrdenPro_Venta*/
	@ManyToOne
	@JoinColumn(name="id_venta_fk", referencedColumnName = "id_ventas")
	private Venta id_venta_fk;
	
	
	/*EstadoOrdenPro_OrdenPro*/
	@ManyToOne
	@JoinColumn(name="id_EstadoOrdenPro_fk", referencedColumnName = "id_estado_produccion")
	private Estado_orden_produccion id_EstadoOrdenPro_fk;
	
	/*Salida___OrdenPro*/
	@OneToMany(mappedBy ="id_orden_pro_fk")
	private List <Salida>ListSalida;
	
	
	
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

	public Detalle_de_produccion getId_detallePro_fk() {
		return id_detallePro_fk;
	}

	public void setId_detallePro_fk(Detalle_de_produccion id_detallePro_fk) {
		this.id_detallePro_fk = id_detallePro_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Venta getId_venta_fk() {
		return id_venta_fk;
	}

	public void setId_venta_fk(Venta id_venta_fk) {
		this.id_venta_fk = id_venta_fk;
	}

	public Estado_orden_produccion getId_EstadoOrdenPro_fk() {
		return id_EstadoOrdenPro_fk;
	}

	public void setId_EstadoOrdenPro_fk(Estado_orden_produccion id_EstadoOrdenPro_fk) {
		this.id_EstadoOrdenPro_fk = id_EstadoOrdenPro_fk;
	}

	
	
}
