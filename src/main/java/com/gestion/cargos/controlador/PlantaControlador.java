package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.servicios.implementacion.PlantaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planta")
public class PlantaControlador {

    @Autowired
    private PlantaServicioImpl plantaServicio;

    @GetMapping(value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlantaDTO>> findAllPlanta(){
       return  ResponseEntity.ok(this.plantaServicio.findAll());
    }

    @GetMapping(value = "/{plantaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaDTO>findByPlantaId(@PathVariable Long plantaId){

        return ResponseEntity.ok(this.plantaServicio.findByPlantaId(plantaId));
    }

    @PostMapping(value = "/create" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePlanta(@RequestBody PlantaRequest request){
        this.plantaServicio.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{plantaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>updatePlanta(@PathVariable Long plantaId, @RequestBody PlantaRequest request){

        if (this.plantaServicio.existByPlantaId(plantaId)){
            return  new ResponseEntity<>(new Mensaje("La Planta de Cargo no existe"), HttpStatus.NOT_FOUND);
        }

        this.updatePlanta(plantaId, request);

        return ResponseEntity.ok(Boolean.TRUE);
    }


}
