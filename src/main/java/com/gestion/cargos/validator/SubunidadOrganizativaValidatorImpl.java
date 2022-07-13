package com.gestion.cargos.validator;



import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.SubunidadOrganizativaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class SubunidadOrganizativaValidatorImpl implements SubunidadOrganizativaValidator{

	@Override
	public void validator(SubunidadOrganizativaRequest request) throws ApiUnprocessableEntity {
		
        if(request.getCodigoGuarani() < 0 )
		    message("El codigo no es valido ");
        
        if(request.getNombre() == null || request.getNombre().isEmpty())
        	message("El nombre es requerido"); 
       
        if(request.getUnidadOrganizativaId() == null) {
        	
        	message("La unidad organizativa es requerida");
        }
        			
	}

	public void message(String message) throws ApiUnprocessableEntity{
		
		throw new ApiUnprocessableEntity(message);
	}
}
