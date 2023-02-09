package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.dto.CargoRequest;
import com.gestion.cargos.servicios.implementacion.CargoServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
public class CargoControllador {

    @Autowired
    CargoServicioImpl cargoServicio;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCargo(@RequestBody CargoRequest request) throws ApiUnprocessableEntity {

        this.cargoServicio.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCargo(@RequestBody CargoRequest request, @PathVariable("id") Long id){

        //if(!this.cargoServicio
         this.cargoServicio.update(id, request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/{nroCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CargoDTO> getCargoByCodigo(@PathVariable("nroCodigo") Long nroCodigo){
        return ResponseEntity.ok(this.cargoServicio.findByIdCargo(nroCodigo));
    }


}
