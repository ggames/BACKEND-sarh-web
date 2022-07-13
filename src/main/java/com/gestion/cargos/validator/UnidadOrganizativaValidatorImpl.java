package com.gestion.cargos.validator;

import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.UnidadOrganizativaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class UnidadOrganizativaValidatorImpl implements UnidadOrganizativaValidator {

	@Override
	public void validator(UnidadOrganizativaRequest request) throws ApiUnprocessableEntity {

		if (request.getNombre() == null || request.getNombre().isEmpty()) {
			message("El nombre de la Unidad Organizativa es obligatorio");
		}

		if (request.getDirectorId() < 0) {

			message("El ID del director debe ser mayor que cero");

		}
		if (request.getViceDirectorId() < 0) {

			message("El ID del vicedirector debe ser mayor que cero");

		}
	}

	private void message(String message) throws ApiUnprocessableEntity {

		throw new ApiUnprocessableEntity(message);
	}
}
