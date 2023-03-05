package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.dto.PlantaRequest;
import com.gestion.cargos.dto.PuntoDetailDTO;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.repositorio.PlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.PlantaServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlantaServicioImpl implements PlantaServicio {

    @Autowired
    private PlantaRepositorio plantaRepositorio;

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
    public PlantaDTO findByPlantaId(Long plantaId) {
        Planta planta = this.plantaRepositorio.findById(plantaId).orElseThrow();
        return MHelpers.modelMapper().map(planta, PlantaDTO.class);
    }

    @Override
    public PlantaDTO findByPlantaByCargo(Long cargo) {
        Planta planta = this.plantaRepositorio.findByPlantaByCargo(cargo).orElseThrow();
        return MHelpers.modelMapper().map(planta, PlantaDTO.class);
    }

    @Override
    public void save(PlantaRequest request) {

        Planta planta = MHelpers.modelMapper().map(request, Planta.class);

        this.plantaRepositorio.save(planta);
    }

    @Override
    public void update(Long plantaId, PlantaRequest request) {

        Optional<Planta> planta = this.plantaRepositorio.findById(plantaId);

        Planta uPlanta = planta.get();


        uPlanta.setAgenteId(request.getAgenteId());
        uPlanta.setCargoId(request.getCargoId());
        uPlanta.setFechaMovimiento(request.getFechaMovimiento());
        uPlanta.setMotivoMovimiento(request.getMotivoMovimiento());

        this.plantaRepositorio.save(uPlanta);
    }

    @Override
    public boolean existByPlantaId(Long plantaId) {

        return this.plantaRepositorio.existsById(plantaId);
    }
}
