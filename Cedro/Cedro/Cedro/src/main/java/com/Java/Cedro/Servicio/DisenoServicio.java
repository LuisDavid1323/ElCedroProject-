package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Diseno;

public interface DisenoServicio {
	
	public List<Diseno> listarTodosLosDisenos();

	public Diseno guardarDiseno(Diseno Diseno);

	public Diseno obtenerDisenoPorId(Integer id_diseno);

	public Diseno actualizarDiseno(Diseno Diseno);

	public void eliminarDiseno(Integer id_diseno);
}
