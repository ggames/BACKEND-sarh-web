package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.dto.PuntoDetailDTO;
import com.gestion.cargos.enums.ECargoNombre;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.EstadoCargo;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.repositorio.PlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.PlantaServicio;
import com.gestion.cargos.utils.MHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlantaServicioImpl implements PlantaServicio {

    Logger logger = LoggerFactory.getLogger(PlantaServicioImpl.class);
    @Autowired
    private PlantaRepositorio plantaRepositorio;

    @Autowired
    private PuntosManager puntosManager;
    //private ManagerPlantaCargo managerPlantaCargo;



    @Override
    public List<PlantaDTO> findAll() {
        Iterable<Planta> plantalist = this.plantaRepositorio.findAll();
        List<PlantaDTO> plantalistDTO = new ArrayList<>();

        for (Planta planta: plantalist) {
            PlantaDTO plantaDto = MHelpers.modelMapper().map(planta, PlantaDTO.class);
            plantalistDTO.add(plantaDto);
        }

        return plantalistDTO;
    }

    @Override
    public List<PuntoDetailDTO> findByPlantaOfPuntos() {
      //  Iterable<PuntoDetailDTO> puntosList = this.plantaRepositorio.fetchDataLeftJoin();
        List<PuntoDetailDTO> lista_PuntoDetail = this.plantaRepositorio.fetchDataLeftJoin();


        return lista_PuntoDetail;
   //     return null;
    }

    @Override
    public List<PlantaDTO> findByAgente(Agente agente) {
        List<Planta> plantas = this.plantaRepositorio.findByAgenteId(agente);
        List<PlantaDTO>plantasDTO = new ArrayList<>();
        plantas.forEach(planta -> {
            PlantaDTO plantaDTO = MHelpers.modelMapper().map(planta, PlantaDTO.class);
            plantasDTO.add(plantaDTO);
        });

        return plantasDTO;
    }


    @Override
    public PlantaDTO findByPlantaId(Long plantaId) {
        Planta planta = this.plantaRepositorio.findById(plantaId).orElseThrow();
        return MHelpers.modelMapper().map(planta, PlantaDTO.class);
    }

    @Override
    public List<PlantaDTO> findByPlantaByCargo(Long cargo) {
        List <Planta> plantas = this.plantaRepositorio.findByPlantaByCargo(cargo);
        if(plantas.isEmpty()){
            return null;
        }
        List<PlantaDTO> plantasDto = new ArrayList<>();
        for (Planta planta: plantas
             ) {
            PlantaDTO plantaDto = MHelpers.modelMapper().map(planta, PlantaDTO.class);
            plantasDto.add(plantaDto);
        }

        return plantasDto;
    }

    @Override
    public void save(PlantaRequest request) {

        Planta planta = MHelpers.modelMapper().map(request, Planta.class);

        this.plantaRepositorio.save(planta);
    }

    @Override
    public boolean update(Long plantaId, PlantaRequest request) {

        Optional<Planta> planta = this.plantaRepositorio.findById(plantaId);

        Planta uPlanta = planta.get();

        PlantaDTO plantadto = MHelpers.modelMapper().map(planta.get(), PlantaDTO.class);

        uPlanta.setAgenteId(request.getAgenteId());
        uPlanta.setCargoId(request.getCargoId());
        uPlanta.setSubunidadOrganizativaId(request.getSubunidadOrganizativaId());
        uPlanta.setFechaMovimiento(request.getFechaMovimiento());
        uPlanta.setMotivoMovimiento(request.getMotivoMovimiento());
        uPlanta.setFechaInicio(request.getFechaInicio());
        uPlanta.setFechaFin(request.getFechaFin());
        logger.info("NO EXISTE PLANTA ACTIVA CON DICHO CARGO " + request.getFechaCese() );
      if((request.getLic_Desde() != null || request.getFechaCese() != null)
         && request.getCargoId().getCaracter().getId() == 3
        ){
      // if(!managerPlantaCargo.existeCargoActivos(plantadto)) {
           logger.info("NO EXISTE PLANTA ACTIVA CON DICHO CARGO");
           uPlanta.setLic_Desde(request.getLic_Desde());
           uPlanta.setFechaCese(request.getFechaCese());
           puntosManager.ReestablecerPuntos(request.getCargoId().getPuntoId().getId());
          // uPlanta.getCargoId().setEstadoCargo(new EstadoCargo(1L, ECargoNombre.VACANTE_DEFINITIVA, "Vacante Definitiva", null));

      // }
       //else{
       //    return  false;
      // }

      }

        this.plantaRepositorio.save(uPlanta);
        return true;
    }

    @Override
    public boolean existByPlantaId(Long plantaId) {

        return this.plantaRepositorio.existsById(plantaId);
    }
}
