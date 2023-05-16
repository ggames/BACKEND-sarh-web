package com.gestion.cargos.validator;



import com.gestion.cargos.repositorio.SubunidadOrganizativaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.SubunidadOrganizativaRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class SubunidadOrganizativaValidatorImpl implements SubunidadOrganizativaValidator{

    @Autowired
	SubunidadOrganizativaRepositorio subunidadRepositorio;

	@Override
	public void validator(SubunidadOrganizativaRequest request) throws ApiUnprocessableEntity {
		
        if(request.getCodigoGuarani().isEmpty()  )
		    message("El codigo no es valido ");

		if(this.subunidadRepositorio.existsByCodigoGuarani(request.getCodigoGuarani()))
			message("El codigo ya existe, debe ingresar un nuevo codigo");
        
        if(request.getNombre() == null || request.getNombre().isEmpty())
        	message("El nombre es requerido"); 
       
        if(request.getUnidadOrganizativaId() == null) {
        	
        	message("El Departamento correspondiente a la materia es requerida");
        }

        			
	}

	public void message(String message) throws ApiUnprocessableEntity{
		
		throw new ApiUnprocessableEntity(message);
	}
}
