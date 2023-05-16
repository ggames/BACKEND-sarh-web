package com.gestion.cargos.controlador;

import com.gestion.cargos.repositorio.UnidadOrganizativaRepositorio;
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
import com.gestion.cargos.dto.UnidadOrganizativaRequest;
import com.gestion.cargos.servicios.implementacion.UnidadOrganizativaServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.UnidadOrganizativaValidatorImpl;

@RestController
@RequestMapping("/unidad/")
public class UnidadOrganizativaControlador {

	@Autowired
	UnidadOrganizativaRepositorio unidadOrganizativaRepositorio;
	@Autowired
	private UnidadOrganizativaServicioImpl unidadOrganizativaServicio;

	@Autowired
	private UnidadOrganizativaValidatorImpl unidadOrganizativaValidator;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allUnidadOrganizativa() {

		return ResponseEntity.ok(this.unidadOrganizativaRepositorio.findAll());
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUnidadOrganizativa(@RequestBody UnidadOrganizativaRequest request)
			throws ApiUnprocessableEntity {

		this.unidadOrganizativaValidator.validator(request);

		this.unidadOrganizativaServicio.saveUnidadOrganizativa(request);

		return ResponseEntity.ok(Boolean.TRUE);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@PathVariable("id") Long id,@RequestBody UnidadOrganizativaRequest request)
			throws ApiUnprocessableEntity {

		if (!this.unidadOrganizativaServicio.existeUnidadOrganizativa(id))
			return new ResponseEntity(new Mensaje("Unidad Organizativa no encontrada"), HttpStatus.NOT_FOUND);

		this.unidadOrganizativaValidator.validator(request);
		this.unidadOrganizativaServicio.saveUnidadOrganizativa(request);

		return ResponseEntity.ok(Boolean.TRUE);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findUnidadOrganizativaById(@PathVariable("id") Long id){
	
		return ResponseEntity.ok(unidadOrganizativaServicio.obtenerUnidadOrganizativa(id));
	}
	
}
