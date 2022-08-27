package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.PuntoDTO;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.servicios.implementacion.PuntoServicioImpl;
import com.gestion.cargos.validator.PuntoValidatorImpl;

import java.util.List;


@RestController
@RequestMapping("/puntos/")
public class PuntoControlador {

    @Autowired
    PuntoValidatorImpl puntoValidator;

    @Autowired
    PuntoServicioImpl puntoServicio;

    Logger logger = LoggerFactory.getLogger(PuntoControlador.class);

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody() PuntoRequest request) {

        logger.info("OBJETO " + request.getOrigenes());
        this.puntoValidator.validator(request);
        this.puntoServicio.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{puntoId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long puntoId,@RequestBody() PuntoRequest request){
         if(!this.puntoServicio.existPunto(puntoId)){
             throw new RuntimeException("No existe el Punto!");
         }

         this.puntoValidator.validator(request);
         this.puntoServicio.update(puntoId, request);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PuntoDTO>> findAllPunto(){
        return ResponseEntity.ok (this.puntoServicio.findAll());
    }

    @GetMapping("/{puntoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PuntoDTO>findByPuntoId(@PathVariable Long puntoId){
        return ResponseEntity.ok(this.puntoServicio.findByPuntoId(puntoId));
    }


}
