package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.Mensaje;
import com.gestion.cargos.dto.RolPlantaDTO;
import com.gestion.cargos.dto.RolPlantaRequest;
import com.gestion.cargos.servicios.implementacion.RolPlantaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rolplanta")
public class RolPlantaControlador {
    @Autowired
    private RolPlantaServicioImpl rolPlantaServicio;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolPlantaDTO>> findAll() {
        return ResponseEntity.ok(this.rolPlantaServicio.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolPlantaDTO> findByPlantaByID(@PathVariable Long id) {
        return ResponseEntity.ok(this.rolPlantaServicio.findByPlantaId(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> save(@RequestBody RolPlantaRequest request) {
        this.rolPlantaServicio.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody RolPlantaRequest request) {
        if (!this.rolPlantaServicio.exitsRolPlanta(id)) {
            return new ResponseEntity(new Mensaje("No existe el Rol de Planta"), HttpStatus.NOT_FOUND);
        }
        this.rolPlantaServicio.update(id, request);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
