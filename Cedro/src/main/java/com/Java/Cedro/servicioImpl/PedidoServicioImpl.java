package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.PedidoServicio;
import com.Java.Cedro.modelo.Pedido;
import com.Java.Cedro.repositorio.PedidoRepositorio;

@Service
public class PedidoServicioImpl implements PedidoServicio {
	
	@Autowired
	private PedidoRepositorio repositorio;
	
	
	@Override
	public List<Pedido> listarTodosLospedidos() {
		return repositorio.findAll();
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
		return repositorio.save(pedido);
	}

	@Override
	public Pedido obtenerPedidoPorId(Integer id_pedido) {
		return repositorio.findById(id_pedido).get();
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		return repositorio.save(pedido);
	}

	@Override
	public void eliminarPedido(Integer id_pedido) {
		repositorio.deleteById(id_pedido);
		
	}

		

		
}
