package com.gestion.cargos.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gestion.cargos.dto.IndicePorcentajeRequest;
import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.dto.TipoCargoRequest;
import com.gestion.cargos.excepciones.BusinessException;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.servicios.implementacion.TipoCargoServicioImpl;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tipocargos/")
public class TipoCargoControlador {

    Logger logger = LoggerFactory.getLogger(TipoCargoControlador.class);

    @Autowired
    private TipoCargoServicioImpl tipoCargoServicio;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoCargoDTO>> findAll() {
        return ResponseEntity.ok(this.tipoCargoServicio.findAll());
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoCargoDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tipoCargoServicio.findByTipoCargoId(id));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveTipoCargo(@RequestBody TipoCargoRequest request) {
        this.tipoCargoServicio.save(request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateTipoCargo(@PathVariable Long id, @RequestBody TipoCargoRequest request) {
        if (!this.tipoCargoServicio.existTipoCargo(id)) {
            throw new BusinessException("P-401", HttpStatus.NOT_FOUND, "El tipo de cargo no existe");
        }
        this.tipoCargoServicio.update(id, request);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value= "/updateAll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateAllTipoCargo(@RequestBody IndicePorcentajeRequest body) {
        List<TipoCargoDTO> tiposCargosDTO = this.tipoCargoServicio.findAll();
        logger.info("Tipo Cargo " + tiposCargosDTO.size() );

        if (tiposCargosDTO == null) {
            throw new BusinessException("P-401", HttpStatus.NOT_FOUND, "No hay elementos para actualizar");
        }
        List<TipoCargo> tiposCargos = new ArrayList<>();
        tiposCargosDTO.forEach(x -> {
            TipoCargo tpCargo = MHelpers.modelMapper().map(x, TipoCargo.class);
            tiposCargos.add(tpCargo);
        });

        this.tipoCargoServicio.updateAll(tiposCargos, body);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
