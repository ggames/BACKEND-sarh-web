package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.PuntoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.servicios.implementacion.PuntoServicioImpl;
import com.gestion.cargos.validator.PuntoValidatorImpl;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/punto")
public class PuntoControlador {

    @Autowired
    PuntoValidatorImpl puntoValidator;

    @Autowired
    PuntoServicioImpl puntoServicio;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody() PuntoRequest request) {

        this.puntoValidator.validator(request);
        this.puntoServicio.save(request);
    }

    @PutMapping("/update/{puntoId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long puntoId, PuntoRequest request){
         if(!this.puntoServicio.existPunto(puntoId)){
             throw new RuntimeException("No existe el Punto!");
         }

         this.puntoValidator.validator(request);
         this.puntoServicio.update(puntoId, request);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PuntoDto>> findAll(){
        return ResponseEntity.ok (this.puntoServicio.findAll());
    }
    @GetMapping("/{puntoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PuntoDto>findByPuntoId(@PathVariable Long puntoId){
        return ResponseEntity.ok(this.puntoServicio.findByPuntoId(puntoId));
    }


}
