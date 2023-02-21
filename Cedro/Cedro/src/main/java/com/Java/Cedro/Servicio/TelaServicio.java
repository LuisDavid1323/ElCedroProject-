package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Tela;


public interface TelaServicio {

	
	public List<Tela> listarTodasLasTelas();

	public Tela guardarTela(Tela tela);

	public Tela obtenerTelaPorId(Integer id_telas);

	public Tela actualizarTela(Tela tela);

	public void eliminarTela(Integer id_telas);
}
