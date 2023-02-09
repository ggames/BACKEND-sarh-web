package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.EstadoCargoDTO;
import com.gestion.cargos.enums.ECargoNombre;
import com.gestion.cargos.modelo.EstadoCargo;
import com.gestion.cargos.repositorio.EstadoCargoRepositorio;
import com.gestion.cargos.servicios.interfaz.EstadoCargoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EstadoCargoServicioImpl implements EstadoCargoServicio {

    @Autowired
    EstadoCargoRepositorio estadoCargoRepositorio;

    public Optional<EstadoCargo> getByEstadoNombre(ECargoNombre cargoNombre){
        return estadoCargoRepositorio.findByNombre(cargoNombre);
    }

    public void save(EstadoCargo estadoCargo){
        estadoCargoRepositorio.save(estadoCargo);
    }

    @Override
    public List<EstadoCargoDTO> findAll() {
        List<EstadoCargoDTO> estadoCargoDTOS = new ArrayList<>();
        Iterable<EstadoCargo> estadoCargos = this.estadoCargoRepositorio.findAll();

        for (EstadoCargo estadocargo: estadoCargos
         ) {
            EstadoCargoDTO dto = MHelpers.modelMapper().map(estadocargo, EstadoCargoDTO.class);
            estadoCargoDTOS.add(dto);
        }
        return estadoCargoDTOS;
    }

    @Override
    public EstadoCargoDTO findByEstadoCargo(Long id) {
        Optional<EstadoCargo> estadoCargo  = this.estadoCargoRepositorio.findById(id);

        if(!estadoCargo.isPresent()){
            return null;
        }

        return MHelpers.modelMapper().map(estadoCargo, EstadoCargoDTO.class);
    }


}
