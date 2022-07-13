package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.UnidadOrganizativaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Service
public interface UnidadOrganizativaValidator {

	void validator(UnidadOrganizativaRequest request) throws ApiUnprocessableEntity;
}
