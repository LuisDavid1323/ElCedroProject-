package com.Java.Cedro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Java.Cedro.modelo.orden_de_produccion;

public interface OrdenpRepositorio extends JpaRepository<orden_de_produccion, Integer>{

}
