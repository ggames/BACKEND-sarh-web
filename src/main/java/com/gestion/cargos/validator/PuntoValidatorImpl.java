package com.gestion.cargos.validator;

import com.gestion.cargos.excepciones.BusinessException;
import com.gestion.cargos.excepciones.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoRequest;

@Service
public class PuntoValidatorImpl {

    public void validator(PuntoRequest request) {
        if (request.getTipo_cargo() == null) {
            throw new BusinessException("P-401", HttpStatus.INTERNAL_SERVER_ERROR,"El Código de Cargo es obligatorio");
        }
        if(request.getPuntos_disponibles() < 0){
            throw new BusinessException("P-401", HttpStatus.INTERNAL_SERVER_ERROR, "La cantidad de Puntos disponible debe ser mayor que Cero");
        }


    }

}
