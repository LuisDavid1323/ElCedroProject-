package com.Java.Cedro.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Java.Cedro.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long>{
	
	 @Query(value= "SELECT * FROM rol WHERE rol.id_rol= 4", nativeQuery = true )
	 List<Rol> asignarRol();
}
