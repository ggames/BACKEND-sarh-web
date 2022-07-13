package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Service
public interface EstadoPlantaValidator {
 
	void validator(EstadoPlantaRequest request) throws ApiUnprocessableEntity;
}
