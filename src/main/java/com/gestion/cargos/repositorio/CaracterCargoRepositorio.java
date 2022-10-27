package com.gestion.cargos.repositorio;

import com.gestion.cargos.enums.cCaracterNombre;
import com.gestion.cargos.modelo.CargoCaracter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CaracterCargoRepositorio extends JpaRepository<CargoCaracter, Integer> {

    Optional<CargoCaracter> findByCaraterNombre(cCaracterNombre caracterNombre);

}
