package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.CaracterDTO;
import com.gestion.cargos.modelo.CargoCaracter;
import com.gestion.cargos.repositorio.CaracterCargoRepositorio;
import com.gestion.cargos.servicios.interfaz.CaracterCargoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CaracterCargoServicioImpl implements CaracterCargoServicio {

    @Autowired
    CaracterCargoRepositorio caracterCargoRepositorio;



    public void save(CargoCaracter cargoCaracter){
        caracterCargoRepositorio.save(cargoCaracter);
    }

    @Override
    public List<CaracterDTO> findAll() {
        Iterable<CargoCaracter> caracteres = caracterCargoRepositorio.findAll();
        List<CaracterDTO> caracteresDTO = new ArrayList<>();

        for (CargoCaracter caracter : caracteres
        ) {
            CaracterDTO dto = MHelpers.modelMapper().map(caracter, CaracterDTO.class);
            caracteresDTO.add(dto);
        }
        return caracteresDTO;
    }

    @Override
    public CaracterDTO findByCaracterId(Long id) {
        Optional<CargoCaracter> caracter = this.caracterCargoRepositorio.findById(id);
        if( !caracter.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(caracter, CaracterDTO.class);
    }
}
