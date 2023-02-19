package com.Java.Cedro.Servicio;

import java.util.List;
import com.Java.Cedro.modelo.Madera;

public interface MaderaServicio {
	
	public List<Madera> listarTodasLasMadera();

	public Madera guardarMadera(Madera madera);

	public Madera obtenerMaderaPorId(Integer Id_maderas);

	public Madera actualizarMadera(Madera madera);

	public void eliminarMadera(Integer Id_maderas);
}
