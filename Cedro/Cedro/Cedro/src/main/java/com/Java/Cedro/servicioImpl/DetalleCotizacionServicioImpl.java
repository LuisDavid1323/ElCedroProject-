package com.Java.Cedro.servicioImpl;

import java.util.Date;
import java.util.List;
import com.Java.Cedro.modelo.*;
import com.Java.Cedro.modelo.enums.EstadoCotizacionEnum;
import com.Java.Cedro.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.Java.Cedro.DTO.DetalleCotizacionDTO;
import com.Java.Cedro.Servicio.DetalleCotizacionServicio;
import com.Java.Cedro.Servicio.EmailServicio;

@Service
public class DetalleCotizacionServicioImpl implements DetalleCotizacionServicio {

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
	private DisenoRepositorio disenoRepositorio;

	@Autowired
	private CProductoRepositorio categoriaRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private EmailServicio emailServicio;

	@Autowired
	private CotizacionRepositorio cotizacionRepositorio;

	@Override
	public List<Detalle_cotizacion> listarTodosLosDetalle() {
		return detalleCotizacionRepositorio.findAll();
	}

	@Override
	public Detalle_cotizacion obtenerDetallePorId(Integer id_detalle_cotizacion) {
		return detalleCotizacionRepositorio.findById(id_detalle_cotizacion).get();
	}

	@Override
	public Detalle_cotizacion actualizarDetalle(Integer id, DetalleCotizacionDTO detalleDto) {

		Producto productoDb = this.productoRepositorio.findById(detalleDto.getId_producto_fk()).orElse(null);
		Tela telaDb = this.telaRepositorio.findById(detalleDto.getId_tela_fk()).orElse(null);
		Madera maderaDb = this.maderaRepositorio.findById(detalleDto.getId_maderas_fk()).orElse(null);
		Categoria_producto cProductoDb = this.categoriaRepositorio.findById(detalleDto.getId_Categoria_producto_fk())
				.orElse(null);
		Diseno disenoDb = this.disenoRepositorio.findById(detalleDto.getId_diseno_fk()).orElse(null);
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
		Categoria_producto cProductoDb = this.categoriaRepositorio.findById(detalleDto.getId_Categoria_producto_fk())
				.orElse(null);
		Diseno disenoDb = this.disenoRepositorio.findById(detalleDto.getId_diseno_fk()).orElse(null);

		Detalle_cotizacion Dcoti = new Detalle_cotizacion();
		Dcoti.setId_producto_fk(productoDb);
		Dcoti.setId_tela_fk(telaDb);
		Dcoti.setId_maderas_fk(maderaDb);
		Dcoti.setId_Categoria_producto_fk(cProductoDb);
		Dcoti.setId_diseño_fk(disenoDb);
		Dcoti.setCantidad(detalleDto.getCantidad());
		Dcoti.setAlto(detalleDto.getAlto());
		Dcoti.setAncho(detalleDto.getAncho());
		Dcoti.setFondo(detalleDto.getFondo());
		Dcoti.setColor_Madera(detalleDto.getColor_madera());
		Dcoti.setColor_Tela(detalleDto.getColor_tela());

		Detalle_cotizacion saved = this.detalleCotizacionRepositorio.save(Dcoti);
		// Crear la cotizacion
		Cotizacion cotizacion = new Cotizacion();
		cotizacion.setFecha(new Date().toString());
		cotizacion.setId_detalle_cotizacion_fk(saved);
		cotizacion.setValorTotal(calcularValor(productoDb.getPrecio(), telaDb.getValor(), maderaDb.getPrecio(),
				detalleDto.getCantidad()));
		cotizacion.setId_Usuarios_fk(getUsuario());
		cotizacion.setEstadoCotizacion(EstadoCotizacionEnum.ABONADO);
		
		if (cotizacion.setEstadoCotizacion(EstadoCotizacionEnum.PAGO)) {
			
		}
		
		
		/* Persistir la cotizacion */
		Cotizacion savedCotizacion = this.cotizacionRepositorio.save(cotizacion);
		String url = crearUrl(savedCotizacion.getId_cotizacion());
		String urlRedirect = "<a href=\"URL\">Clic para pagar</a>";
		urlRedirect = urlRedirect.replace("URL", url);
		this.emailServicio.enviarEmail(getUsuario().getEmail(), "Pagar cotizacion", "Dar clic aqui para pagar la cotización: "+ url);
		return saved;
		
	}
	
	private String crearUrl(Integer idCotizacion){
		return "localhost:8090/cotizacion/pagar/" + idCotizacion;
	}
	
	private Usuario getUsuario() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return this.usuarioRepositorio.findByEmail(username);
	}

	private Double calcularValor(Double precioProducto, Double precioTela, Double precioMedera, Integer cantidad) {
		return (precioProducto + precioMedera + precioTela) * cantidad;
	}
}
