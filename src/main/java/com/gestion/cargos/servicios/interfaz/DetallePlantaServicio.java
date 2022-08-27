package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.DetallePlantaDTO;
import com.gestion.cargos.dto.DetallePlantaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetallePlantaServicio {

    List<DetallePlantaDTO> findAll();

    DetallePlantaDTO findByDetallePlantaId(Long id);

    void save(DetallePlantaRequest request);

    void update(Long id, DetallePlantaRequest request);

    void delete(Long id);

    boolean existDetallePlantaId(Long id);

}
