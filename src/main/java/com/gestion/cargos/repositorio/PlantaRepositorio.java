package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaRepositorio extends JpaRepository<Planta, Long> {

    //List<Planta> findByCaracter(String caracter);

    Optional<Planta> findByAgenteId(Long agenteID);
    @Query(value = "SELECT * FROM cargos.planta p LEFT JOIN cargos.cargos c ON p.cargo_id = " +
            "c.id LEFT JOIN cargos.agente a ON p.agente_id = a.id  WHERE c.id_cargo = :cargo", nativeQuery = true)
    Optional<Planta> findByPlantaByCargo(@Param("cargo") Long cargo);
}
