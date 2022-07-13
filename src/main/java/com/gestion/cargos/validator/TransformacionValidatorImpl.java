package com.gestion.cargos.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.TransformacionRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class TransformacionValidatorImpl implements TransformacionValidator {

	@Override
	public void validator(TransformacionRequest request) throws ApiUnprocessableEntity {
		
       
		
        if(!this.ValidarNroResolucion(request.getNumeroResolucion())) {
        	message("Nro de Resolución no es valido");
        }
        
	}

	private void message(String message) throws ApiUnprocessableEntity{
         
		throw new ApiUnprocessableEntity(message);		
	}
	
	private boolean ValidarNroResolucion(String nroresol) {
	       
		Pattern pattern = Pattern.compile("\\d{1,4}/\\d{4}");

        Matcher matcher = pattern.matcher(nroresol);
        
        return matcher.find();	
	}

}
