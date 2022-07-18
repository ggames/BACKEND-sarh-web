package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.HistoriaPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaPlantaRepositorio extends JpaRepository<HistoriaPlanta, Long> {

}
