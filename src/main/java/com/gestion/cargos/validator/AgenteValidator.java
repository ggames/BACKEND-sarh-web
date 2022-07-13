package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;


/*
 * Interface para la validacion de datos recibidos para 
 * la creación de Agentes
 * 
 * */

@Service
public interface AgenteValidator {

	void validator(AgenteRequest request) throws ApiUnprocessableEntity; 
}
