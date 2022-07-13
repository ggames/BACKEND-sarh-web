package com.gestion.cargos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.cargos.modelo.EstadoPlanta;

@Repository
public interface EstadoPlantaRepositorio extends JpaRepository<EstadoPlanta, Long> {

	
}
