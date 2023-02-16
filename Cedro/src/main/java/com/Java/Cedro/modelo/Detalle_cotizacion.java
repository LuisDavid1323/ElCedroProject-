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
@Table(name="Detalle_cotizacion")
public class Detalle_cotizacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detalle_cotizacion;
	
	/*DetalleC_Cotizacion*/
	@OneToMany(mappedBy ="id_detalle_cotizacion_fk")
    private List<Cotizacion> ListCotizacion;
	
	@Column(name="Cantidad")
	private Integer Cantidad;
	
	@Column
	private String Color_Madera;
	
	@Column
	private String Color_Tela;
	
	/*DetalleC_Producto*/
	@ManyToOne
	@JoinColumn(name="id_producto_fk", referencedColumnName = "id_producto")
	private Producto id_producto_fk;
	
	/*DetalleC_Telas*/
	@ManyToOne
	@JoinColumn(name="id_tela_fk", referencedColumnName = "id_telas")
	private Tela id_tela_fk;
	
	
	
	/*DetalleC_Maderas*/
	@ManyToOne
	@JoinColumn(name="id_madera_fk", referencedColumnName = "Id_maderas")
	private Madera id_maderas_fk;
	
	
	/*DetalleC_Maderas*/
	@ManyToOne
	@JoinColumn(name="id_Categoria_producto_fk", referencedColumnName = "id_categorias_productos")
	private Categoria_producto id_Categoria_producto_fk;
	
	/*DetalleC_Diseno*/
	@ManyToOne
	@JoinColumn(name="id_diseno_fk", referencedColumnName = "id_diseno")
	private Diseno id_diseno_fk;


	//Getters and Setters
	
	
	public Integer getId_detalle_cotizacion() {
		return id_detalle_cotizacion;
	}



	public void setId_detalle_cotizacion(Integer id_detalle_cotizacion) {
		this.id_detalle_cotizacion = id_detalle_cotizacion;
	}



	public List<Cotizacion> getListCotizacion() {
		return ListCotizacion;
	}



	public void setListCotizacion(List<Cotizacion> listCotizacion) {
		ListCotizacion = listCotizacion;
	}



	public Integer getCantidad() {
		return Cantidad;
	}



	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}



	public Tela getId_tela_fk() {
		return id_tela_fk;
	}



	public Diseno getId_diseno_fk() {
		return id_diseno_fk;
	}



	public void setId_diseno_fk(Diseno id_diseno_fk) {
		this.id_diseno_fk = id_diseno_fk;
	}



	public void setId_tela_fk(Tela id_tela_fk) {
		this.id_tela_fk = id_tela_fk;
	}



	public Madera getId_maderas_fk() {
		return id_maderas_fk;
	}



	public void setId_maderas_fk(Madera id_maderas_fk) {
		this.id_maderas_fk = id_maderas_fk;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Producto getId_producto_fk() {
		return id_producto_fk;
	}



	public void setId_producto_fk(Producto id_producto_fk) {
		this.id_producto_fk = id_producto_fk;
	}



	public Categoria_producto getId_Categoria_producto_fk() {
		return id_Categoria_producto_fk;
	}



	public void setId_Categoria_producto_fk(Categoria_producto id_Categoria_producto_fk) {
		this.id_Categoria_producto_fk = id_Categoria_producto_fk;
	}



	public Diseno getId_diseño_fk() {
		return id_diseno_fk;
	}



	public void setId_diseño_fk(Diseno id_diseno_fk) {
		this.id_diseno_fk = id_diseno_fk;
	}
	
	


	public String getColor_Madera() {
		return Color_Madera;
	}



	public void setColor_Madera(String color_Madera) {
		Color_Madera = color_Madera;
	}



	public String getColor_Tela() {
		return Color_Tela;
	}



	public void setColor_Tela(String color_Tela) {
		Color_Tela = color_Tela;
	}



	/*Constructor*/
	public Detalle_cotizacion() {
		super();
		this.id_detalle_cotizacion = id_detalle_cotizacion;
		ListCotizacion = getListCotizacion();
		Cantidad = getCantidad();
		this.id_producto_fk = id_producto_fk;
		this.id_tela_fk = id_tela_fk;
		this.id_maderas_fk = id_maderas_fk;
		this.id_Categoria_producto_fk = id_Categoria_producto_fk;
		this.id_diseno_fk = id_diseno_fk;
		this.Color_Madera = Color_Madera; 
		this.Color_Tela =  Color_Tela;
	}


	
	
	
}
