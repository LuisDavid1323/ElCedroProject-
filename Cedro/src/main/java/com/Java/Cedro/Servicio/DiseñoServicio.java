package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Diseño;

public interface DiseñoServicio {
	
	public List<Diseño> listarTodosLosDiseños();

	public Diseño guardarDiseño(Diseño Diseño);

	public Diseño obtenerDiseñoPorId(Integer id_diseño);

	public Diseño actualizarDiseño(Diseño Diseño);

	public void eliminarDiseño(Integer id_diseño);
}
