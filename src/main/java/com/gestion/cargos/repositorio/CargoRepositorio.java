package com.gestion.cargos.repositorio;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.modelo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo, Long> {

   Cargo findByIdCargo(Long nrocargo);
}
