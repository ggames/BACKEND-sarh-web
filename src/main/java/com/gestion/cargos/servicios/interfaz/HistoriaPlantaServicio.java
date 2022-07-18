package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.HistoriaPlantaDto;
import com.gestion.cargos.dto.HistoriaPlantaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoriaPlantaServicio {

    List<HistoriaPlantaDto> findAll();

    HistoriaPlantaDto findByHistoriaPlantaId(Long id);

    void save(HistoriaPlantaRequest request);

    void update(Long id, HistoriaPlantaRequest request);

    void delete(Long id);

    boolean existHistoriaPlantaId(Long id);

}
