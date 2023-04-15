package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.PuntoOrigenDTO;
import com.gestion.cargos.dto.PuntoOrigenRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PuntoOrigenServicio {

    public void updatePuntosOcupados(Long id, int cantidad);

    List<PuntoOrigenDTO> findAll();

    void deletePuntoOrigen(Long id);
}
