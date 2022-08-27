package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.DetallePlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePlantaRepositorio extends JpaRepository<DetallePlanta, Long> {

}
