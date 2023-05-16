package com.gestion.cargos.validator;

import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoRequest;

@Service
public interface PuntoValidator {

  void validator(PuntoRequest request) throws ApiUnprocessableEntity;
	
}
