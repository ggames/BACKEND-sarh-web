package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.PlantaDto;
import com.gestion.cargos.dto.PlantaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantaServicio {

    List<PlantaDto> findAll();

    PlantaDto findByPlantaId(Long plantaId);

    public void save(PlantaRequest planta);

    public void update(Long plantaId, PlantaRequest planta);

    boolean existByPlantaId(Long plantaId);

}
