package com.gestion.cargos.repositorio;

import com.gestion.cargos.enums.ECargoNombre;
import com.gestion.cargos.modelo.EstadoCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoCargoRepositorio extends JpaRepository<EstadoCargo, Integer> {

    Optional<EstadoCargo> findByNombreEstado(ECargoNombre cargoNombre);
}
