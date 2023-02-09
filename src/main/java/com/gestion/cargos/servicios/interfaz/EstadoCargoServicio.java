package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.EstadoCargoDTO;

import java.util.List;

public interface EstadoCargoServicio {

    public List<EstadoCargoDTO> findAll();

    EstadoCargoDTO findByEstadoCargo(Long id);
}
