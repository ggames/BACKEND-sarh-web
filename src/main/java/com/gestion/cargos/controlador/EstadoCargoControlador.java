package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.EstadoCargoDTO;
import com.gestion.cargos.servicios.implementacion.EstadoCargoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estadocargo/")
public class EstadoCargoControlador {

    @Autowired
    EstadoCargoServicioImpl estadoCargoServicio;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadoCargoDTO>> getAllEstadosCargos() {
        return ResponseEntity.ok(this.estadoCargoServicio.findAll());
    }

}
