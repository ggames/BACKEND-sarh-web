package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaRepositorio extends JpaRepository<Planta, Long> {

    List<Planta> findByCaracter(String caracter);

    Optional<Planta> findByAgenteId(Long agenteID);
}