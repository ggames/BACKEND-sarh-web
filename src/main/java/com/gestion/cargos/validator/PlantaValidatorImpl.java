package com.gestion.cargos.validator;

import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class PlantaValidatorImpl implements PlantaValidator {

    @Override
    public void validator(PlantaRequest request) throws ApiUnprocessableEntity {

        if (request.getCargoId() == null) {
            message("Debe elegir un cargo para crear la plaza");
        }
        if (request.getAgenteId() == null) {
            message("Debe elegir un agente para crear la plaza");
        }
        if (request.getFechaInicio() == null) {
            message("Debe ingresar una fecha de Ingreso al cargo");
        }
        if( request.getSubunidadOrganizativaId() == null){
            message("Debe elegir una materia asociada a la plaza");
        }
    }

    private void message(String message) throws ApiUnprocessableEntity {
        throw new ApiUnprocessableEntity(message);
    }

    public void validator() throws ApiUnprocessableEntity {

    }
}
