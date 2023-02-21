package com.Java.Cedro.DTO;

public class DetalleCotizacionDTO {

	/* DetalleCotizacion */

	private Integer id_detalle_cotizacion;
	private Integer cantidad;
	private Integer id_producto_fk;
	private Integer id_tela_fk;
	private Integer id_maderas_fk;
	private Integer id_Categoria_producto_fk;
	private Integer id_diseno_fk;
	private String color_madera;
	private String color_tela;
	private Double Alto;
	private Double Ancho;
	private Double Fondo;

	/* Constructor */

	public DetalleCotizacionDTO(Integer id_detalle_cotizacion, Integer id_detalle_cotizacion_fk, Integer cantidad,
			Integer id_producto_fk, Integer id_tela_fk, Integer id_maderas_fk, Integer id_Categoria_producto_fk,
			Integer id_diseno_fk, Double Alto, Double Ancho, Double Fondo, String color_madera, String color_tela) {

		this.id_detalle_cotizacion = id_detalle_cotizacion;
		this.cantidad = cantidad;
		this.id_producto_fk = id_producto_fk;
		this.id_tela_fk = id_tela_fk;
		this.id_maderas_fk = id_maderas_fk;
		this.id_Categoria_producto_fk = id_Categoria_producto_fk;
		this.id_diseno_fk = id_diseno_fk;
		this.Alto = Alto;
		this.Ancho = Ancho;
		this.Fondo = Fondo;
		this.color_madera = color_madera;
		this.color_tela = color_tela;
	}

	public DetalleCotizacionDTO() {

	}

	/* Getters and Setters */

	public Integer getId_detalle_cotizacion() {
		return id_detalle_cotizacion;
	}

	public void setId_detalle_cotizacion(Integer id_detalle_cotizacion) {
		this.id_detalle_cotizacion = id_detalle_cotizacion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getId_producto_fk() {
		return id_producto_fk;
	}

	public void setId_producto_fk(Integer id_producto_fk) {
		this.id_producto_fk = id_producto_fk;
	}

	public Integer getId_tela_fk() {
		return id_tela_fk;
	}

	public void setId_tela_fk(Integer id_tela_fk) {
		this.id_tela_fk = id_tela_fk;
	}

	public Integer getId_maderas_fk() {
		return id_maderas_fk;
	}

	public void setId_maderas_fk(Integer id_maderas_fk) {
		this.id_maderas_fk = id_maderas_fk;
	}

	public Integer getId_Categoria_producto_fk() {
		return id_Categoria_producto_fk;
	}

	public void setId_Categoria_producto_fk(Integer id_Categoria_producto_fk) {
		this.id_Categoria_producto_fk = id_Categoria_producto_fk;
	}

	public Integer getId_diseno_fk() {
		return id_diseno_fk;
	}

	public void setId_diseno_fk(Integer id_diseno_fk) {
		this.id_diseno_fk = id_diseno_fk;
	}

	public String getColor_madera() {
		return color_madera;
	}

	public void setColor_madera(String color_madera) {
		this.color_madera = color_madera;
	}

	public String getColor_tela() {
		return color_tela;
	}

	public Double getAlto() {
		return Alto;
	}

	public void setAlto(Double alto) {
		Alto = alto;
	}

	public Double getAncho() {
		return Ancho;
	}

	public void setAncho(Double ancho) {
		Ancho = ancho;
	}

	public Double getFondo() {
		return Fondo;
	}

	public void setFondo(Double fondo) {
		Fondo = fondo;
	}

	public void setColor_tela(String color_tela) {
		this.color_tela = color_tela;
	}

}
