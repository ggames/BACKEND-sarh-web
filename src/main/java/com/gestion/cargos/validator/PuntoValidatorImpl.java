package com.gestion.cargos.validator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoRequest;

@Service
public class PuntoValidatorImpl {

    public void validator(PuntoRequest request) {
        if (request.getCodigoCargo().equals("")) {
            throw new RuntimeException("El Codigo de Cargo es obligatorio");
        }

    }

}
