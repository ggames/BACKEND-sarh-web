package com.gestion.cargos.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gestion.cargos.dto.ErrorDTO;



@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDTO error = ErrorDTO.builder().code("P-500").message(ex.getMessage()).build();

        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }

}
