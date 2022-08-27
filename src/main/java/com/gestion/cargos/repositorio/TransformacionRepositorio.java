package com.gestion.cargos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.cargos.modelo.Transformacion;

@Repository
public interface TransformacionRepositorio extends JpaRepository<Transformacion, Long>  {
 
	@Transactional(readOnly = true )
	Optional<Transformacion> findByNumeroResolucion(String nroresol);
	
	
}
