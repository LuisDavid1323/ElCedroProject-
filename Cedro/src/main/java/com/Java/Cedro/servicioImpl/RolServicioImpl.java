package com.Java.Cedro.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.Cedro.Servicio.RolServicio;
import com.Java.Cedro.modelo.Rol;
import com.Java.Cedro.repositorio.RolRepositorio;

@Service
public class RolServicioImpl implements RolServicio{

	@Autowired
	private RolRepositorio rolrepo;
	
	@Override
	public List<Rol> lstrol() {
		
		return rolrepo.findAll();
	}
 
	
}
