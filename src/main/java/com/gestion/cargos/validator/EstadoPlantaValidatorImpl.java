package com.gestion.cargos.validator;

import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

public class EstadoPlantaValidatorImpl implements EstadoPlantaValidator {

	@Override
	public void validator(EstadoPlantaRequest request) throws ApiUnprocessableEntity {
		
		if(request.getNombre().isBlank() || request.getNombre().isEmpty() ) {
			message("El nombre de Estado de Planta es requerido ");
		}
		
	}
	
	void message(String message) throws ApiUnprocessableEntity {
		
		throw new ApiUnprocessableEntity(message);
	}

}
