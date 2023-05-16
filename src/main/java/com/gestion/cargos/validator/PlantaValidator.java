package com.gestion.cargos.validator;

import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

public interface PlantaValidator {

    void validator(PlantaRequest request) throws ApiUnprocessableEntity;
}
