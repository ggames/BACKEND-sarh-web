package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.HistoriaPlantaDto;
import com.gestion.cargos.dto.HistoriaPlantaRequest;
import com.gestion.cargos.excepciones.BusinessException;
import com.gestion.cargos.servicios.implementacion.HistoriaPlantaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historiaplanta")
public class HistoriaPlantaControlador {

    @Autowired
    private HistoriaPlantaServicioImpl historiaPlantaServicio;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<HistoriaPlantaDto>> findAll(){
       return ResponseEntity.ok(this.historiaPlantaServicio.findAll());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<HistoriaPlantaDto>findByHistoriaPlantaId(@PathVariable Long id){
        return ResponseEntity.ok(this.historiaPlantaServicio.findByHistoriaPlantaId(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Boolean>saveHistoriaPlanta(@RequestBody HistoriaPlantaRequest request){

        this.historiaPlantaServicio.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}")
    private ResponseEntity<Boolean>updateHistoriaPlanta(@PathVariable Long id, @RequestBody HistoriaPlantaRequest request){
        if(!this.historiaPlantaServicio.existHistoriaPlantaId(id)){
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No existe la Historia de la Planta de Cargo");
        }

        this.historiaPlantaServicio.update(id, request);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
