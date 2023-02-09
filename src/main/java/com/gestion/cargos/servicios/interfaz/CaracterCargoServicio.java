package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.CaracterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaracterCargoServicio {

    List<CaracterDTO> findAll();

    CaracterDTO findByCaracterId(Long id);
}
