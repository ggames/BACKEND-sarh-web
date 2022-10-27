package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.modelo.CargoCaracter;
import com.gestion.cargos.repositorio.CaracterCargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.cargos.enums.cCaracterNombre;

import java.util.Optional;

@Service
public class CaracterCargoServicio {

    @Autowired
    CaracterCargoRepositorio caracterCargoRepositorio;

    public Optional<CargoCaracter>getByCaracterNombre(cCaracterNombre caracter){
        return caracterCargoRepositorio.findByCaraterNombre(caracter);
    }

    public void save(CargoCaracter cargoCaracter){
        caracterCargoRepositorio.save(cargoCaracter);
    }
}
