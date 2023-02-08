package com.Java.Cedro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Java.Cedro.modelo.Estado_cotizacion;

@Repository
public interface EstadocRepositorio extends JpaRepository<Estado_cotizacion, Integer>{
	

}
