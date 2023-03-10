package com.Java.Cedro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Java.Cedro.modelo.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	
	 Usuario findByEmail(String email);
	
	
	public Usuario findByResetPasswordToken(String token);

}
