package com.gestion.cargos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.cargos.modelo.SubunidadOrganizativa;

@Repository
public interface SubunidadOrganizativaRepositorio extends JpaRepository<SubunidadOrganizativa, Long> {
    
	
}
