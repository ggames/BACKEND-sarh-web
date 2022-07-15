package com.gestion.cargos.validator;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoRequest;

@Service
public interface PuntoValidator {

  void validator(PuntoRequest request);  
	
}
