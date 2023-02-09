package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.CaracterDTO;
import com.gestion.cargos.modelo.CargoCaracter;
import com.gestion.cargos.repositorio.CaracterCargoRepositorio;
import com.gestion.cargos.servicios.implementacion.CaracterCargoServicioImpl;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("caracteres/")
public class CaracterControlador {



    @Autowired
    CaracterCargoServicioImpl caracterCargoServicio;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CaracterDTO>> findAll() {
         return ResponseEntity.ok(this.caracterCargoServicio.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CaracterDTO> findByCaracterCargoId(@PathVariable Long id){
        return ResponseEntity.ok(this.caracterCargoServicio.findByCaracterId(id));
    }

}
