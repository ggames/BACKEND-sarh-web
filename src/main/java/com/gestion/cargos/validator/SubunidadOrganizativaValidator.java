package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.SubunidadOrganizativaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Service
public interface SubunidadOrganizativaValidator {

	void validator(SubunidadOrganizativaRequest request) throws ApiUnprocessableEntity;
		
	
}
