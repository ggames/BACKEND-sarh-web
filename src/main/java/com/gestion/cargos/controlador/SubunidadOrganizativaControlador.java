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
import com.gestion.cargos.dto.SubunidadOrganizativaRequest;
import com.gestion.cargos.servicios.implementacion.SubunidadOrganizativaServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.SubunidadOrganizativaValidatorImpl;

@RestController
@RequestMapping("/subunidad/")
public class SubunidadOrganizativaControlador {
	@Autowired
	private SubunidadOrganizativaServicioImpl subunidadOrganizativaServicio;

	@Autowired
	private SubunidadOrganizativaValidatorImpl SUvalidator;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerTodasSubunidadesOrg() {

		return ResponseEntity.ok(this.subunidadOrganizativaServicio.findAll());
	}
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?>obtenerSubunidadOrganizativa(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(this.subunidadOrganizativaServicio.findBySubunidadOrganizativaId(id));
	}


	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardarSubunidadOrganizativa(@RequestBody SubunidadOrganizativaRequest request)
			throws ApiUnprocessableEntity {

		this.SUvalidator.validator(request);

		this.subunidadOrganizativaServicio.save(request);

		return ResponseEntity.ok(Boolean.TRUE);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarSubunidadOrganizativa(@RequestBody SubunidadOrganizativaRequest req,
			@PathVariable("id") Long id) throws ApiUnprocessableEntity {

		if (!this.subunidadOrganizativaServicio.existeSubunidadOrganizativaId(id))
			return new ResponseEntity(new Mensaje("No existe el registro"), HttpStatus.NOT_FOUND);

		this.SUvalidator.validator(req);

		this.subunidadOrganizativaServicio.update(req, id);

		return ResponseEntity.ok(Boolean.TRUE);

	}
	
}
