package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Pedido;

public interface PedidoServicio{

	public List<Pedido> listarTodosLospedidos();
	
	public Pedido guardarPedido(Pedido pedido);
	
	public Pedido obtenerPedidoPorId(Integer id_pedido);
	
	public Pedido actualizarPedido(Pedido pedido);
	
	public void eliminarPedido(Integer id_pedido);
}
