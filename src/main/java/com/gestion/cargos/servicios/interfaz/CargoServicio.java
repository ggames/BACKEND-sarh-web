package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.dto.CargoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CargoServicio {

    List<CargoDTO> findAll();

    CargoDTO findByIdCargo(Long cargoId);



    void save(CargoRequest request);

    void update(Long cargoId, CargoRequest request);

}
