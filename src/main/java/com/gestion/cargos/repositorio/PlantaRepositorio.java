package com.gestion.cargos.repositorio;

import com.gestion.cargos.dto.PuntoDetailDTO;
import com.gestion.cargos.modelo.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaRepositorio extends JpaRepository<Planta, Long> {

    //List<Planta> findByCaracter(String caracter);

    @Transactional(readOnly = true)
    @Query(value = "SELECT pp.id AS id, ag.nombre AS nombre ,ag.apellido AS apellido," +
            "    tc.cargo AS cargo , ca.id_cargo AS codCargo , pp.puntos_disponibles AS disponible, es.nombre AS estado" +
            "                 FROM cargos.planta pl LEFT JOIN  cargos.cargos ca ON pl.cargo_id = ca.id  " +
            "            LEFT JOIN cargos.estado_cargo es ON es.id = ca.estado_cargo_id LEFT JOIN cargos.agente ag ON ag.id = pl.agente_id " +
            "                 RIGHT JOIN cargos.puntos pp ON pp.id = ca.punto_id LEFT JOIN cargos.tipo_cargos tc " +
            "                 ON tc.id = pp.tipo_cargo_id ", nativeQuery = true)
    List<PuntoDetailDTO> fetchDataLeftJoin();

    Optional<Planta> findByAgenteId(Long agenteID);
    @Query(value = "SELECT * FROM cargos.planta p LEFT JOIN cargos.cargos c ON p.cargo_id = " +
            "c.id LEFT JOIN cargos.agente a ON p.agente_id = a.id  WHERE c.id_cargo = :cargo", nativeQuery = true)
    Optional<Planta> findByPlantaByCargo(@Param("cargo") Long cargo);
}
