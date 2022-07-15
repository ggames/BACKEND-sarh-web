package com.gestion.cargos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.servicios.implementacion.PuntoServicioImpl;
import com.gestion.cargos.validator.PuntoValidatorImpl;

@RestController
@RequestMapping("/punto")
public class PuntoControlador {

    @Autowired
    PuntoValidatorImpl puntoValidator;

    @Autowired
    PuntoServicioImpl puntoServicio;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody() PuntoRequest request) {

        /*
         * if (request.getCodigoCargo().equals("")) {
         * throw new RuntimeException("El Codigo de Cargo es obligatorio");
         * }
         */
        this.puntoValidator.validator(request);
        this.puntoServicio.save(request);
    }
}
