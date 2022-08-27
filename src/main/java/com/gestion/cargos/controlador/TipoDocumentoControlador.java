package com.gestion.cargos.controlador;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.cargos.modelo.TipoDocumento;

import com.gestion.cargos.servicios.implementacion.TipoDocumentoServicioImpl;

@RestController
@RequestMapping("/api/v1/")
public class TipoDocumentoControlador {


	@Autowired
	private TipoDocumentoServicioImpl tipoDocServicio;

	@GetMapping("/tiposdocs")
	public ResponseEntity<List<TipoDocumento>> listarTodosTipoDocumento(){
		
		return  ResponseEntity.ok(tipoDocServicio.listadoTipoDocumento()); 
	}
	
	@GetMapping("tipodocs/{id}")
	public ResponseEntity<?> obtenerTipoDocumento(@PathVariable("id") int id){
	    
		return ResponseEntity.ok(tipoDocServicio.obtenerTipoDocumento(id));
	}
}
