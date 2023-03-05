package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.RolPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPlantaRepositorio extends JpaRepository<RolPlanta, Long> {
}
