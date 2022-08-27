package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.dto.CargoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CargoServicio {

    List<CargoDTO> findAll();

    CargoDTO findByCargoId(Long cargoId);

    void save(CargoRequest request);

    void update(Long cargoId, CargoRequest request);

}
