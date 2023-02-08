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





@Entity
@Table(name="Telas")
public class Tela  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_telas;
	
	@Column(name="Nombre_tela")
	private String Nombre_tela;
	
	@Column(name="Valor")
	private String Valor;
	
	/*DetalleC_Telas*/
	@OneToMany(mappedBy ="id_tela_fk")
	private List <Detalle_cotizacion>ListDetalleCotizacion;
	
	
	
	
	//Getters and Setters
	
	public Integer getId_telas() {
		return id_telas;
	}
	
	

	public List<Detalle_cotizacion> getListDetalleCotizacion() {
		return ListDetalleCotizacion;
	}



	public void setListDetalleCotizacion(List<Detalle_cotizacion> listDetalleCotizacion) {
		ListDetalleCotizacion = listDetalleCotizacion;
	}



	public void setId_telas(Integer id_telas) {
		this.id_telas = id_telas;
	}

	public String getNombre_tela() {
		return Nombre_tela;
	}

	public void setNombre_tela(String nombre_tela) {
		Nombre_tela = nombre_tela;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
