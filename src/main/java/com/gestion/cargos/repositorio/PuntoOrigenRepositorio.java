package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.PuntoOrigen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoOrigenRepositorio extends JpaRepository<PuntoOrigen, Long> {
}
