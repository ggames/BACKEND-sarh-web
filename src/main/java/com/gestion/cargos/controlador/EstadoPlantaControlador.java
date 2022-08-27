package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.EstadoPlantaDTO;
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

import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.servicios.implementacion.EstadoPlantaServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.EstadoPlantaValidatorImpl;

import java.util.List;

/**
 * @author ggames
 *
 */
@RestController
@RequestMapping(value = "/estadoplanta")
public class EstadoPlantaControlador {

	  @Autowired
	  private EstadoPlantaServicioImpl estadoPlantaServicio;
	 
	  @Autowired
      private EstadoPlantaValidatorImpl estadoPlantaValidator;
	  
	  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<List<EstadoPlantaDTO>>findAll(){
		  
		  return ResponseEntity.ok(this.estadoPlantaServicio.findAll());
	  }
	  
	  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?>findByEstadoPlantaId(@PathVariable("id") Long id){
		  
		  return ResponseEntity.ok(this.estadoPlantaServicio.findByEstadoPlantaId(id));
	  }

	  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?>saveEstadoPlanta(@RequestBody EstadoPlantaRequest req) throws ApiUnprocessableEntity{

         this.estadoPlantaValidator.validator(req);
        
         this.estadoPlantaServicio.save(req);
         
         return ResponseEntity.ok(Boolean.TRUE);
	  }
	 
	  @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?> updateEstadoPlanta(@RequestBody EstadoPlantaRequest req,@PathVariable("id") Long id) throws ApiUnprocessableEntity{
         if(!this.estadoPlantaServicio.existEstadoPlanta(id)) {
        	 return new ResponseEntity(new Mensaje("No existe el Estado de Planta para modificar"), HttpStatus.NOT_FOUND);
         }
         
         this.estadoPlantaValidator.validator(req);
         
         this.estadoPlantaServicio.update(req, id);
         
         return ResponseEntity.ok(Boolean.TRUE);
	  }
}