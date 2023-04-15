package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.PuntoOrigen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoOrigenRepositorio extends JpaRepository<PuntoOrigen, Long> {

    @Query(value = "DELETE FROM cargos.origen_puntos origen" +
            " WHERE origen.punto_id = :punto_id", nativeQuery = true)
    void deleteByPuntoId(@Param("punto_id") Long punto_id);
}
