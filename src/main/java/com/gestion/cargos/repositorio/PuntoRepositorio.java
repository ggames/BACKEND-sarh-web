package com.gestion.cargos.repositorio;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.cargos.modelo.Punto;

@Repository
public interface PuntoRepositorio extends JpaRepository<Punto, Long> {

	@Transactional(readOnly = true)
	List<Punto> findByNombreCargo(String nombre);

	@Transactional(readOnly = true)
	List<Punto> findByCodigoCargo(String codigoCargo);


	/*@Transactional(readOnly = true)
	List<Punto> findByDedicacionCargo(String dedicacion);*/
}
