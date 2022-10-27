package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.enums.ECargoNombre;
import com.gestion.cargos.enums.cCaracterNombre;
import com.gestion.cargos.modelo.EstadoCargo;
import com.gestion.cargos.repositorio.EstadoCargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoCargoServicio {

    @Autowired
    EstadoCargoRepositorio estadoCargoRepositorio;

    public Optional<EstadoCargo> getByEstadoNombre(ECargoNombre cargoNombre){
        return estadoCargoRepositorio.findByNombreEstado(cargoNombre);
    }

    public void save(EstadoCargo estadoCargo){
        estadoCargoRepositorio.save(estadoCargo);
    }

}
