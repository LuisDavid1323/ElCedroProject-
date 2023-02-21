package com.Java.Cedro.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java.Cedro.Servicio.MaderaServicio;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.repositorio.MaderaRepositorio;

@Service
public class MaderaServicioImpl implements MaderaServicio{
	
	@Autowired
	private MaderaRepositorio repositorio;
	
	@Override
	public List<Madera> listarTodasLasMadera() {
		return repositorio.findAll();
	}

	@Override
	public Madera guardarMadera(Madera madera) {
		return repositorio.save(madera);
	}

	@Override
	public Madera obtenerMaderaPorId(Integer Id_maderas) {
		return repositorio.findById(Id_maderas).get();
	}

	@Override
	public Madera actualizarMadera(Madera madera) {
		return repositorio.save(madera);
	}

	@Override
	public void eliminarMadera(Integer Id_maderas) {
		repositorio.deleteById(Id_maderas);
		
	}

}
