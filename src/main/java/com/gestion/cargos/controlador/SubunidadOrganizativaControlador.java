package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.SubunidadOrganizativaDTO;
import com.gestion.cargos.modelo.UnidadOrganizativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.util.List;

@RestController
@RequestMapping("/subunidad/")
public class SubunidadOrganizativaControlador {
	@Autowired
	private SubunidadOrganizativaServicioImpl subunidadOrganizativaServicio;

	@Autowired
	private SubunidadOrganizativaValidatorImpl SUvalidator;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubunidadOrganizativaDTO>> obtenerTodasSubunidadesOrg() {

		return ResponseEntity.ok(this.subunidadOrganizativaServicio.findAll());
	}

	@GetMapping(value = "/unidad/{unidad}")
	public ResponseEntity<List<SubunidadOrganizativaDTO>>
	obtenerSubunidadesByUOrganizativa(@PathVariable UnidadOrganizativa unidad){
		return ResponseEntity.ok(this.subunidadOrganizativaServicio.findByUnidadOrganizativa(unidad));
	}

	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<SubunidadOrganizativaDTO>obtenerSubunidadOrganizativa(@PathVariable("id") Long id){

		return ResponseEntity.ok(this.subunidadOrganizativaServicio.findBySubunidadOrganizativaId(id));
	}


	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubunidadOrganizativaRequest> guardarSubunidadOrganizativa(@RequestBody SubunidadOrganizativaRequest request)
			throws ApiUnprocessableEntity {

		this.SUvalidator.validator(request);

		this.subunidadOrganizativaServicio.save(request);

		return new ResponseEntity<>(this.getHttpHeaders(request.getId()),HttpStatus.CREATED);
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

	HttpHeaders getHttpHeaders(Long id){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id").buildAndExpand(id).toUri());
		return httpHeaders;
	}
}
