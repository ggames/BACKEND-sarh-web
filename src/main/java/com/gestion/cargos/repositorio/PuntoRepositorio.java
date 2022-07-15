package com.gestion.cargos.repositorio;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.cargos.modelo.Punto;

@Repository
public interface PuntoRepositorio extends JpaRepository<Punto, Long> {

	@Transactional(readOnly = true)
	Optional<Punto> findByNombreCargo(String nombre);
}
