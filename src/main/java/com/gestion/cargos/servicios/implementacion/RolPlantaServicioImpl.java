package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.RolPlantaDTO;
import com.gestion.cargos.dto.RolPlantaRequest;
import com.gestion.cargos.modelo.RolPlanta;
import com.gestion.cargos.repositorio.RolPlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.RolPlantaServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RolPlantaServicioImpl implements RolPlantaServicio {

    @Autowired
    private RolPlantaRepositorio rolPlantaRepositorio;


    @Override
    public List<RolPlantaDTO> findAll() {

        Iterable<RolPlanta> rolPlantas_lista = this.rolPlantaRepositorio.findAll();

        List<RolPlantaDTO> rolesPlanta = new ArrayList<>();

        rolPlantas_lista.forEach(rol_planta -> {
            RolPlantaDTO rolPlantaDTO = MHelpers.modelMapper().map(rol_planta, RolPlantaDTO.class);
            rolesPlanta.add(rolPlantaDTO);
        });

        return rolesPlanta;
    }



    @Override
    public void save(RolPlantaRequest request) {
         RolPlanta rol_planta = MHelpers.modelMapper().map(request, RolPlanta.class);

         this.rolPlantaRepositorio.save(rol_planta);
    }

    @Override
    public void update(Long id, RolPlantaRequest request) {
        Optional<RolPlanta> rol_planta = this.rolPlantaRepositorio.findById(id);

        RolPlanta uRolPlanta = rol_planta.get();
        uRolPlanta.setTipoRol(request.getTipoRol());
        uRolPlanta.setPlantaId(request.getPlantaId());
        uRolPlanta.setSubunidadOrganizativaId(request.getSubunidadOrganizativaId());

        this.rolPlantaRepositorio.save(uRolPlanta);
    }

    @Override
    public RolPlantaDTO findById(Long id) {
        Optional<RolPlanta> rol_planta = this.rolPlantaRepositorio.findById(id);

        RolPlantaDTO rolPlantaDTO = MHelpers.modelMapper().map(rol_planta.get(), RolPlantaDTO.class);
        return rolPlantaDTO;
    }

    @Override
    public RolPlantaDTO findByPlantaId(Long id) {
       Optional<RolPlanta> rol_planta = this.rolPlantaRepositorio.findByPlantaId(id);
        RolPlantaDTO rolPlantaDTO = MHelpers.modelMapper().map(rol_planta.get(), RolPlantaDTO.class);
        return  rolPlantaDTO;
    }


    @Override
    public boolean exitsRolPlanta(Long id) {
        return this.rolPlantaRepositorio.existsById(id);
    }


}
