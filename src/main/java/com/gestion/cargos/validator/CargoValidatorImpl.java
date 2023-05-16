package com.gestion.cargos.validator;

import com.gestion.cargos.dto.CargoRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class CargoValidatorImpl implements CargoValidator{
    @Override
    public void validator(CargoRequest request) throws ApiUnprocessableEntity {

        if(request.getIdCargo() < 0) {
            message("El codigo de Cargo debe ser mayor a (0) Cero");
        }
        if(request.getUnidadOrganizativaId() == null) {
            message("Debe elegir un Departamento para la materia");
        }

        if(request.getCaracter() == null) {
            message("Debe elegir un opción de Caracter del Cargo");
        }

        if(request.getPuntoId() == null){
            message("Debe elegir un Punto para el cargo");
        }

        if(request.getEstadoCargo() == null) {
            message("Debe elegir un estado para el cargo");
        }

        if(request.getTransfCreacionId() == null) {
            message("Debe elegir una transformación de creación");
        }
    }

    private void message(String message) throws ApiUnprocessableEntity {
        throw  new ApiUnprocessableEntity(message);
    }
}
