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

import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.servicios.implementacion.EstadoPlantaServicioImpl;
import com.gestion.cargos.utils.exceptions.ApiUnprocessableEntity;
import com.gestion.cargos.validator.EstadoPlantaValidatorImpl;

/**
 * @author ggames
 *
 */
@RestController
@RequestMapping("/estadoplanta/")
public class EstadoPlantaControlador {

	  @Autowired
	  private EstadoPlantaServicioImpl estadoPlantaServicio;
	 
	  @Autowired
      private EstadoPlantaValidatorImpl estadoPlantaValidator;
	  
	  @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?>obtenerTodosEstadoPlanta(){
		  
		  return ResponseEntity.ok(this.estadoPlantaServicio.findAll());
	  }
	  
	  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?>obtenerEstadoPlantaId(@PathVariable("id") Long id){
		  
		  return ResponseEntity.ok(this.estadoPlantaServicio.findByEstadoPlantaId(id));
	  }

	  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?>guardarEstadoPlanta(@RequestBody EstadoPlantaRequest req) throws ApiUnprocessableEntity{

         this.estadoPlantaValidator.validator(req);
        
         this.estadoPlantaServicio.save(req);
         
         return ResponseEntity.ok(Boolean.TRUE);
	  }
	 
	  @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<?> actualizarEstadoPlanta(@RequestBody EstadoPlantaRequest req,@PathVariable("id") Long id) throws ApiUnprocessableEntity{
         if(!this.estadoPlantaServicio.existeEstadoPlanta(id)) {
        	 return new ResponseEntity(new Mensaje("No existe el Estado de Planta para modificar"), HttpStatus.NOT_FOUND);
         }
         
         this.estadoPlantaValidator.validator(req);
         
         this.estadoPlantaServicio.update(req, id);
         
         return ResponseEntity.ok(Boolean.TRUE);
	  }
}