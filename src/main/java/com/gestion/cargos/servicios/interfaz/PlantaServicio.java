package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.dto.PuntoDetailDTO;
import com.gestion.cargos.modelo.Agente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantaServicio {

    List<PlantaDTO> findAll();

    List<PuntoDetailDTO> findByPlantaOfPuntos();

    List<PlantaDTO> findByAgente(Agente agente);

    PlantaDTO findByPlantaId(Long plantaId);

    List<PlantaDTO> findByPlantaByCargo(Long cargo);

    public void save(PlantaRequest planta);

    public boolean update(Long plantaId, PlantaRequest planta);

    boolean existByPlantaId(Long plantaId);

}
