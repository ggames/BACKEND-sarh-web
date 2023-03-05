package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.RolPlantaDTO;
import com.gestion.cargos.dto.RolPlantaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolPlantaServicio {

   List<RolPlantaDTO> findAll();

   void save(RolPlantaRequest request);

   void update(Long id, RolPlantaRequest request);

   RolPlantaDTO findById(Long id);

   boolean exitsRolPlanta(Long id);

}
