package com.gestion.cargos.repositorio;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.modelo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  CargoRepositorio extends JpaRepository<Cargo, Long> {

   Optional<Cargo> findByIdCargo(Long nrocargo);
}
