package com.gestion.cargos.validator;

import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class EstadoPlantaValidatorImpl implements EstadoPlantaValidator {

	@Override
	public void validator(EstadoPlantaRequest request) throws ApiUnprocessableEntity {
		
		if(request.getNombre().equals("") || request.getNombre().isBlank() ) {
			message("El nombre de Estado de Planta es requerido ");
		}
		
	}
	
	void message(String message) throws ApiUnprocessableEntity {
		
		throw new ApiUnprocessableEntity(message);
	}

}
