package com.Java.Cedro.modelo;

import com.Java.Cedro.modelo.enums.EstadoCotizacionEnum;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Cotizacion")
public class Cotizacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cotizacion;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="ValorTotal")
	private Double ValorTotal;
	
	@Column(name="estado_cotizacion")
	@Enumerated(EnumType.STRING)
	private EstadoCotizacionEnum EstadoCotizacion;
	
	/*DetalleC_Cotizacion*/
	@ManyToOne
	@JoinColumn(name="id_detalle_cotizacion_fk", referencedColumnName = "id_detalle_cotizacion")
	private Detalle_cotizacion id_detalle_cotizacion_fk;
	
	
	
	/*Cotizacion__Usuarios*/
	@ManyToOne
	@JoinColumn(name="id_Usuarios_fk")
	private Usuario id_Usuarios_fk;
	
	
	
	
	/*Cotizacion__Ordenp*/
	@OneToMany(mappedBy ="id_cotizacion_fk")
	private List <OrdenProduccion>ListOrdenp;
	
	
	//Getters and Setters
	
	public Integer getId_cotizacion() {
		return id_cotizacion;
	}


	public void setId_cotizacion(Integer id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Detalle_cotizacion getId_detalle_cotizacion_fk() {
		return id_detalle_cotizacion_fk;
	}


	public void setId_detalle_cotizacion_fk(Detalle_cotizacion id_detalle_cotizacion_fk) {
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}
	
	
	
	public EstadoCotizacionEnum getEstadoCotizacion() {
		return EstadoCotizacion;
	}


	public void setEstadoCotizacion(EstadoCotizacionEnum estadoCotizacion) {
		EstadoCotizacion = estadoCotizacion;
	}


	public Usuario getId_Usuarios_fk() {
		return id_Usuarios_fk;
	}


	public void setId_Usuarios_fk(Usuario id_Usuarios_fk) {
		this.id_Usuarios_fk = id_Usuarios_fk;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Double getValorTotal() {
		return ValorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		ValorTotal = valorTotal;
	}
	
	



	
	
	/*Constructor*/
	public Cotizacion(Detalle_cotizacion id_detalle_cotizacion_fk) {
		super();
		this.id_detalle_cotizacion_fk = id_detalle_cotizacion_fk;
	}

	
	public Cotizacion(){
		
	}
	

	
	
	

	
	
	

	

	
	
	

}
