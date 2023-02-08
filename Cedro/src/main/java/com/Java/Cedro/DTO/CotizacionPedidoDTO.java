package com.Java.Cedro.DTO;


import com.Java.Cedro.modelo.Cliente;
import com.Java.Cedro.modelo.Cotizacion;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.modelo.Estado_cotizacion;


public class CotizacionPedidoDTO{

	/*Cotizacion*/
	private Integer id_cotizacion;
	private String fecha;
	private Estado_cotizacion id_estado_cotizacion_fk;
	private Detalle_cotizacion id_detalle_cotizacion_fk;
	private Cliente id_cliente_fk;
	
	/*Pedido*/
	private Integer id_pedido;
	private String Fecha;
	private Cotizacion id_cotizacion_fk;
	
	
	
	
	
}
