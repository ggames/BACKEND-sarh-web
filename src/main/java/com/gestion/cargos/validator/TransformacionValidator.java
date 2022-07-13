package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.TransformacionRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Service
public interface TransformacionValidator {

	void validator(TransformacionRequest request) throws ApiUnprocessableEntity;
	
}
