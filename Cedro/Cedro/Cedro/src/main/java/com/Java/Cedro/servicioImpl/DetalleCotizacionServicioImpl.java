package com.Java.Cedro.servicioImpl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

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
		cotizacion.setEstadoCotizacion(EstadoCotizacionEnum.NoPago);
		
		
		
		
		/* Persistir la cotizacion */
		
		Cotizacion savedCotizacion = this.cotizacionRepositorio.save(cotizacion);
		String url = crearUrl(savedCotizacion.getId_cotizacion());
		String page = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n"
				+ "<HTML>\r\n"
				+ "\r\n"
				+ "<HEAD>\r\n"
				+ "   <meta charset=\"utf-8\">\r\n"
				+ "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "   <style>\r\n"
				+ "      * {\r\n"
				+ "         font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\r\n"
				+ "      }\r\n"
				+ "      a{\r\n"
				+ "         text-decoration: none;\r\n"
				+ "         color: #DBBA9D;\r\n"
				+ "      }\r\n"
				+ "      a:hover{\r\n"
				+ "         color:#663E39 ;\r\n"
				+ "      }\r\n"
				+ "   </style>\r\n"
				+ "\r\n"
				+ "   <TITLE>Maderas Finas - Pagar</TITLE>\r\n"
				+ "   \r\n"
				+ "</HEAD>\r\n"
				+ "\r\n"
				+ "<BODY style=\"margin: 0; padding: 0;\">   \r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "   \r\n"
				+ "\r\n"
				+ "   <!-- Encabezado -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"background-color: #663E39; padding: 20px; text-align: center;\">\r\n"
				+ "				<h1 style=\"color: #FFFFFF; margin: 0;\">Paga tu cotizacion</h1>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "\r\n"
				+ "	<!-- Cuerpo -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; margin-top: 20px;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"padding: 20px;\">\r\n"
				+ "            \r\n"
				+ "            <center><img  src=\"https://i.postimg.cc/mkky1hxL/logo.jpg\" style=\"height: 200px;width: 400px;\"/></center>\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">Hola\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">por medio de este <a href=URL>link</a>  podras pagar tu cotización de Maderas Finas.</p>\r\n"
				+ "				<p style=\"font-size: 16px; line-height: 24px;\">Gracias por confiar en nosotros.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "\r\n"
				+ "	<!-- Pie de página -->\r\n"
				+ "	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse; margin-top: 20px;\">\r\n"
				+ "		<tr>\r\n"
				+ "			<td style=\"background-color: #DBBA9D; padding: 20px; text-align: center;\">\r\n"
				+ "				<p style=\"color: #000000; font-size: 14px; line-height: 20px; margin: 0;\">copyright &copy;2023 El Cedro.</p>\r\n"
				+ "			</td>\r\n"
				+ "		</tr>\r\n"
				+ "	</table>\r\n"
				+ "</BODY>\r\n"
				+ "\r\n"
				+ "</HTML>";
		
		page = page.replace("URL", '"'+ url + '"');
		try {
			this.emailServicio.enviarEmail(getUsuario().getEmail(),"Hola, " + getUsuario().getNombre() + " " + getUsuario().getApellido() + " paga tu cotización", page);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saved;
		
	}
	
	private String crearUrl(Integer idCotizacion){
		return "http://localhost:8090/cotizacion/pagar/" + idCotizacion;
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
