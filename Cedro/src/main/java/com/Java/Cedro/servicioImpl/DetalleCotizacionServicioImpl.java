package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.DTO.DetalleCotizacionDTO;
import com.Java.Cedro.Servicio.DetalleCotizacionServicio;
import com.Java.Cedro.modelo.Categoria_producto;
import com.Java.Cedro.modelo.Detalle_cotizacion;
import com.Java.Cedro.modelo.Diseño;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.modelo.Producto;
import com.Java.Cedro.modelo.Tela;
import com.Java.Cedro.repositorio.CProductoRepositorio;
import com.Java.Cedro.repositorio.CotizacionRepositorio;
import com.Java.Cedro.repositorio.DetalleCotizacionRepositorio;
import com.Java.Cedro.repositorio.DiseñoRepositorio;
import com.Java.Cedro.repositorio.MaderaRepositorio;
import com.Java.Cedro.repositorio.ProductoRepositorio;
import com.Java.Cedro.repositorio.TelaRepositorio;

@Service
public class DetalleCotizacionServicioImpl implements DetalleCotizacionServicio{

	@Autowired
	private DetalleCotizacionRepositorio detalleCotizacionRepositorio;
	
	@Autowired
	private CotizacionRepositorio Crepositorio;
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Autowired
	private TelaRepositorio telaRepositorio;
	
	@Autowired 
	private MaderaRepositorio maderaRepositorio;
	
	@Autowired
	private DiseñoRepositorio disenoRepositorio;
	
	@Autowired
	private CProductoRepositorio categoriaRepositorio;

	@Override
	public List<Detalle_cotizacion> listarTodosLosDetalle() {
		return detalleCotizacionRepositorio.findAll();
	}

	@Override
	public Detalle_cotizacion obtenerDetallePorId(Integer id_detalle_cotizacion) {
		return detalleCotizacionRepositorio.findById(id_detalle_cotizacion).get();
	}

	@Override
	public Detalle_cotizacion actualizarDetalle(Integer id,DetalleCotizacionDTO detalleDto) {
		
		Producto productoDb = this.productoRepositorio.findById(detalleDto.getId_producto_fk()).orElse(null);
		Tela telaDb = this.telaRepositorio.findById(detalleDto.getId_tela_fk()).orElse(null);
		Madera maderaDb = this.maderaRepositorio.findById(detalleDto.getId_maderas_fk()).orElse(null);
		Categoria_producto cProductoDb = this.categoriaRepositorio.findById(detalleDto.getId_Categoria_producto_fk()).orElse(null);   
		Diseño disenoDb = this.disenoRepositorio.findById(detalleDto.getId_diseno_fk()).orElse(null);
		Detalle_cotizacion detalleCotizacionDb = this.detalleCotizacionRepositorio.findById(id).orElse(null);
		
		detalleCotizacionDb.setId_producto_fk(productoDb);
		detalleCotizacionDb.setId_tela_fk(telaDb);
		detalleCotizacionDb.setId_maderas_fk(maderaDb);
		detalleCotizacionDb.setId_Categoria_producto_fk(cProductoDb);
		detalleCotizacionDb.setId_diseño_fk(disenoDb);

		return detalleCotizacionRepositorio.save(detalleCotizacionDb);
	}

	@Override
	public void eliminarDetalle(Integer id_detalle_cotizacion) {
		detalleCotizacionRepositorio.deleteById(id_detalle_cotizacion);
		
	}

	@Override
	public Detalle_cotizacion guardarDetalle(DetalleCotizacionDTO detalleDto) {
		Producto productoDb = this.productoRepositorio.findById(detalleDto.getId_producto_fk()).orElse(null);
		Tela telaDb = this.telaRepositorio.findById(detalleDto.getId_tela_fk()).orElse(null);
		Madera maderaDb = this.maderaRepositorio.findById(detalleDto.getId_maderas_fk()).orElse(null);
		Categoria_producto cProductoDb = this.categoriaRepositorio.findById(detalleDto.getId_Categoria_producto_fk()).orElse(null);   
		Diseño disenoDb = this.disenoRepositorio.findById(detalleDto.getId_diseno_fk()).orElse(null);
		
		Detalle_cotizacion Dcoti = new Detalle_cotizacion();
		Dcoti.setId_producto_fk(productoDb);
		Dcoti.setId_tela_fk(telaDb);
		Dcoti.setId_maderas_fk(maderaDb);
		Dcoti.setId_Categoria_producto_fk(cProductoDb);
		Dcoti.setId_diseño_fk(disenoDb);
		Dcoti.setCantidad(detalleDto.getCantidad());
		
		
		return this.detalleCotizacionRepositorio.save(Dcoti);
	}

}
