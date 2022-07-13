package com.gestion.cargos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.dto.TransformacionRequest;
import com.gestion.cargos.servicios.implementacion.TransformacionServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;

import com.gestion.cargos.validator.TransformacionValidatorImpl;

@RestController
@RequestMapping("/transformacion/")
public class TransformacionControlador {

	@Autowired
	private TransformacionServicioImpl transformacionServicio;

	@Autowired 
	private TransformacionValidatorImpl transformacionValidator;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> allTransformacion() {

		return ResponseEntity.ok(this.transformacionServicio.findAll());
	}

	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByTransformacionId(@PathVariable("id") int id){
    
		return ResponseEntity.ok(this.transformacionServicio.findByTransformacionId(id));
    
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveTransformacion(@RequestBody TransformacionRequest request) throws ApiUnprocessableEntity{

      	this.transformacionValidator.validator(request);
		
		this.transformacionServicio.save(request);

		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateTransformacion(@PathVariable("id") int id, @RequestBody TransformacionRequest req ) throws ApiUnprocessableEntity{

		if(!this.transformacionServicio.existeTransformacion(id))
		    return new ResponseEntity(new Mensaje("No existe la transformación"), HttpStatus.NOT_FOUND);
		
		this.transformacionValidator.validator(req);
		
		this.transformacionServicio.update(req, id);
		
		return ResponseEntity.ok(Boolean.TRUE);
		
	}

}
