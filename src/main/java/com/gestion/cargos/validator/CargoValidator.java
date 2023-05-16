package com.gestion.cargos.validator;

import com.gestion.cargos.dto.CargoRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

public interface CargoValidator {
    void validator(CargoRequest request) throws ApiUnprocessableEntity;
}
