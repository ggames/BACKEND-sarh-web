package com.gestion.cargos.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

@Component
public class AgenteValidatorImp implements AgenteValidator{

	@Override
	public void validator(AgenteRequest request) throws ApiUnprocessableEntity {
		
		if(request.getNombre() == null || request.getNombre().isEmpty()) {
			message("El nombre es un dato obligatorio");
		}
		
		if(request.getNombre().length() < 3) {
	
			message("El nombre es muy corto,  debe tener minimo 3 caracteres");
		}
		
		if(request.getApellido() == null || request.getApellido().isEmpty()) {
			message("El apellido es un dato obligatorio");
		}
		
		if(request.getApellido().length() < 3) {
	
			message("El apellido es muy corto,  debe tener minimo 3 caracteres");
		}
	    
	   if(!this.ValidarMail(request.getEmail())) {
			
		   message("El formato de correo no es valido");   
	   }   
		
	}
	
	private boolean ValidarMail(String email) {
       
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();	
	}
	
	private void message(String message) throws ApiUnprocessableEntity {
	    
		throw new ApiUnprocessableEntity(message);	
	}

	
}
