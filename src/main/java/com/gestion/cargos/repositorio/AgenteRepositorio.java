package com.gestion.cargos.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.cargos.modelo.Agente;

@Repository
public interface AgenteRepositorio extends JpaRepository<Agente, Long> {
    
	@Transactional(readOnly = true)
	Optional<Agente>findByNombre(String nombre);
	
	public boolean existsByNombre(String nombre);
    
	
}
