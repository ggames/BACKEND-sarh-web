package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.dto.PlantaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantaServicio {

    List<PlantaDTO> findAll();

    PlantaDTO findByPlantaId(Long plantaId);

    PlantaDTO findByPlantaByCargo(Long cargo);

    public void save(PlantaRequest planta);

    public void update(Long plantaId, PlantaRequest planta);

    boolean existByPlantaId(Long plantaId);

}
