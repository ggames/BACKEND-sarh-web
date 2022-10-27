package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.CaracterDTO;
import com.gestion.cargos.modelo.CargoCaracter;
import com.gestion.cargos.repositorio.CaracterCargoRepositorio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("caracteres")
public class CaracterControlador {

    @Autowired
    CaracterCargoRepositorio caracterCargoRepositorio;

    public ResponseEntity<List<CaracterDTO>>findAll(){
        Iterable<CargoCaracter> caracteres = caracterCargoRepositorio.findAll();
        List<CaracterDTO> caracteresDTO = new ArrayList<>();

        for (CargoCaracter caracter: caracteres
             ) {
            CaracterDTO dto = MHelpers.modelMapper().map(caracter, CaracterDTO.class);
            caracteresDTO.add(dto);
        }
        return ResponseEntity.ok(caracteresDTO);
    }

}
