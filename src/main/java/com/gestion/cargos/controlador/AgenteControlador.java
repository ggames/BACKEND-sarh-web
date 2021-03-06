package com.gestion.cargos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.TipoDocumento;
import com.gestion.cargos.servicios.implementacion.AgenteServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.AgenteValidatorImp;

@RestController
@RequestMapping("/agentes/")
public class AgenteControlador {

	@Autowired
	private AgenteServicioImpl agenteServicio;

	@Autowired
	private AgenteValidatorImp agenteValidator;

	// Este metodo sirve para listar todos los agentes

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allAgente() {

		return ResponseEntity.ok(this.agenteServicio.findAll());

	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Object> findByAgenteId(@PathVariable("id") int id) {

		return ResponseEntity.ok(this.agenteServicio.findByAgenteId(id));
	}

	@GetMapping(value = "/by/{nombreAg}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByAgenteNombre(@PathVariable("nombreAg") String nombre) {

		return ResponseEntity.ok(this.agenteServicio.findByNombre(nombre));
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateAgente(@PathVariable("id") int id, @RequestBody AgenteRequest agente)
			throws ApiUnprocessableEntity {
		if (!agenteServicio.existeAgente(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);

		this.agenteValidator.validator(agente);
		this.agenteServicio.update(agente, id);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveAgente(@RequestBody AgenteRequest request) throws ApiUnprocessableEntity {

		this.agenteValidator.validator(request);
		this.agenteServicio.save(request);

		return ResponseEntity.ok(Boolean.TRUE);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{agenteId}/delete")
	public ResponseEntity<Object> deleteAgente(@PathVariable("agenteId") int id) {

		ResponseEntity respuesta;

		if (!this.agenteServicio.existeAgente(id))
			respuesta = new ResponseEntity(new Mensaje("No existe el agente!"), HttpStatus.NOT_FOUND);
		else {
			this.agenteServicio.deleteAgente(id);
			respuesta = ResponseEntity.ok(Boolean.TRUE);
		}

		return respuesta;
	}
}
