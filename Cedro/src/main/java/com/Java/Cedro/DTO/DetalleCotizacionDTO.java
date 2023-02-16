package com.Java.Cedro.DTO;

public class DetalleCotizacionDTO {

	
	/*DetalleCotizacion*/
	
	private Integer id_detalle_cotizacion;
	private Integer cantidad;
	private Integer id_producto_fk;
	private Integer id_tela_fk;
	private Integer id_maderas_fk;
	private Integer id_Categoria_producto_fk;
	private Integer id_diseno_fk;
	private String  Color_Madera;
	private String  Color_Tela;
	
	/*Constructor*/
	
	public DetalleCotizacionDTO(Integer id_detalle_cotizacion, Integer id_detalle_cotizacion_fk, Integer cantidad,
			Integer id_producto_fk, Integer id_tela_fk, Integer id_maderas_fk, Integer id_Categoria_producto_fk,
			Integer id_diseno_fk) {
		
		this.id_detalle_cotizacion = id_detalle_cotizacion;
		this.cantidad = cantidad;
		this.id_producto_fk = id_producto_fk;
		this.id_tela_fk = id_tela_fk;
		this.id_maderas_fk = id_maderas_fk;
		this.id_Categoria_producto_fk = id_Categoria_producto_fk;
		this.id_diseno_fk = id_diseno_fk;
	}
	
	
	
	/*Getters and Setters*/
	
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
	
	
	public DetalleCotizacionDTO() {
		
	}
	
	
}
