package com.gestion.cargos.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gestion.cargos.modelo.UnidadOrganizativa;

public interface UnidadOrganizativaRepositorio extends CrudRepository<UnidadOrganizativa, Long>{

	Optional<UnidadOrganizativa> findByNombre(String nombre);
	
	public boolean existsByNombre(String nombre); 
}
