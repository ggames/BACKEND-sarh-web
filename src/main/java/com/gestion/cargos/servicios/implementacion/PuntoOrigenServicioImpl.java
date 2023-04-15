package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoOrigenDTO;
import com.gestion.cargos.dto.PuntoOrigenRequest;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.PuntoOrigen;
import com.gestion.cargos.repositorio.PuntoOrigenRepositorio;
import com.gestion.cargos.servicios.interfaz.PuntoOrigenServicio;
import com.gestion.cargos.utils.MHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PuntoOrigenServicioImpl implements PuntoOrigenServicio {

    Logger looger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PuntoOrigenRepositorio puntoOrigenRepositorio;

    @Override
    public void updatePuntosOcupados(Long id, int cantidad) {
        Optional<PuntoOrigen> origen = this.puntoOrigenRepositorio.findById(id);

        PuntoOrigen uPuntoOrigen = origen.get();

        uPuntoOrigen.setCantOcupados(cantidad);

        this.puntoOrigenRepositorio.save(uPuntoOrigen);
    }

    @Override
    public List<PuntoOrigenDTO> findAll() {
        Iterable<PuntoOrigen> origenes = this.puntoOrigenRepositorio.findAll();
        List<PuntoOrigenDTO> origenesDTO = new ArrayList<>();

        origenes.forEach(origen -> {
            PuntoOrigenDTO origenDTO = MHelpers.modelMapper().map(origen, PuntoOrigenDTO.class);
            origenesDTO.add(origenDTO);
        });
        return origenesDTO;
    }

    @Override
    public void deletePuntoOrigen(Long id) {
        this.puntoOrigenRepositorio.deleteByPuntoId(id);
        looger.info("Se elimino correctamente el dato  " + id);
    }
}
