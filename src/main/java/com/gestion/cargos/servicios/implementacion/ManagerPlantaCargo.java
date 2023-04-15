package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.*;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;
import com.gestion.cargos.modelo.EstadoCargo;
import com.gestion.cargos.utils.MHelpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerPlantaCargo {

    Logger logger = LoggerFactory.getLogger(ManagerPlantaCargo.class);

    @Autowired
    private ManagerPuntoOrigen managerPuntoOrigen;

    @Autowired
    private EstadoCargoServicioImpl estadoCargoServicio;
    @Autowired
    private PuntosManager puntosManager;

    @Autowired
    private CargoServicioImpl cargoServicio;
    @Autowired
    private PlantaServicioImpl plantaServicio;

    public void actualizarPlantaCargo(Agente agente) {

        List<PlantaDTO> plantasDTO = this.plantaServicio.findByAgente(agente);
        //  Cargo cargo = plantaDTO.getCargoId();
        if (agente.getEsFallecido() == true && agente.getFechaBaja() != null) {
            plantasDTO.forEach(planta -> {
                logger.info("FALLECIDO: " + agente.getEsFallecido() + "  FECHA BAJA " + agente.getFechaBaja());

                EstadoCargoDTO estadoCargo = estadoCargoServicio.findByEstadoCargo(1l);
                EstadoCargo estado = MHelpers.modelMapper().map(estadoCargo, EstadoCargo.class);
                Cargo cargo = planta.getCargoId();
                cargo.setEstadoCargo(estado);
                CargoRequest cargoRequest = MHelpers.modelMapper().map(cargo, CargoRequest.class);
                this.cargoServicio.update(cargo.getId(), cargoRequest);
            });

        }
        if (agente.getFechaBaja() != null && agente.getEsFallecido() == false) {
            plantasDTO.forEach(planta -> {

                EstadoCargoDTO estadoCargo = estadoCargoServicio.findByEstadoCargo(2l);
                EstadoCargo estado = MHelpers.modelMapper().map(estadoCargo, EstadoCargo.class);
                Cargo cargo = planta.getCargoId();
                cargo.setEstadoCargo(estado);
                planta.setFechaFin(agente.getFechaBaja());
                CargoRequest cargoRequest = MHelpers.modelMapper().map(cargo, CargoRequest.class);
                this.cargoServicio.update(cargo.getId(), cargoRequest);

            });

        }
        plantasDTO.forEach(planta -> {
            if (agente.getFechaBaja() == null || planta.getFechaFin() == null) {

                managerPuntoOrigen.eliminarPuntosOrigenByPunto(planta.getCargoId().getPuntoId());
            }
        });

    }

    public void actualizarMovimientoPlantaTransitorio(PlantaRequest request) {

            logger.info("ESTA CONTRATADO ");
            puntosManager.ReestablecerPuntos(request.getCargoId().getPuntoId().getId());
            managerPuntoOrigen.eliminarPuntosOrigenByPunto(request.getCargoId().getPuntoId());
    
    }


    public boolean existeCargoActivos(PlantaDTO planta) {
        boolean existe = false;
        Long idcargo = planta.getCargoId().getIdCargo();
        List<PlantaDTO> plantasDto = this.plantaServicio.findByPlantaByCargo(idcargo);
        for (PlantaDTO plantaDto : plantasDto
        ) {
            if (planta.getId() != plantaDto.getId()) {
                existe = true;
            }
        }

        return existe;
    }
}
