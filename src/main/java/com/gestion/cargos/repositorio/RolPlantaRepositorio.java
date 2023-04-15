package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.RolPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolPlantaRepositorio extends JpaRepository<RolPlanta, Long> {

    @Query(value = "Select * from cargos.rol_planta rp left join cargos.planta pl ON rp.planta_id = pl.id " +
            "where rp.planta_id = :planta", nativeQuery = true)
    Optional<RolPlanta> findByPlantaId(@Param("planta") Long planta);
}
