package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.DetallePlantaDTO;
import com.gestion.cargos.dto.DetallePlantaRequest;
import com.gestion.cargos.excepciones.BusinessException;
import com.gestion.cargos.servicios.implementacion.DetallePlantaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detalleplanta")
public class DetallePlantaControlador {

    @Autowired
    private DetallePlantaServicioImpl detallePlantaServicio;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<DetallePlantaDTO>> findAll(){
       return ResponseEntity.ok(this.detallePlantaServicio.findAll());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<DetallePlantaDTO>findBydetallePlantaId(@PathVariable Long id){
        return ResponseEntity.ok(this.detallePlantaServicio.findByDetallePlantaId(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Boolean>saveDetallePlanta(@RequestBody DetallePlantaRequest request){

        this.detallePlantaServicio.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}")
    private ResponseEntity<Boolean>updateDetallePlanta(@PathVariable Long id, @RequestBody DetallePlantaRequest request){
        if(!this.detallePlantaServicio.existDetallePlantaId(id)){
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No existe la detalle de la Planta de Cargo");
        }

        this.detallePlantaServicio.update(id, request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
