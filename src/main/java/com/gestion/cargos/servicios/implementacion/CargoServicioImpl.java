package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.CargoDTO;
import com.gestion.cargos.dto.CargoRequest;
import com.gestion.cargos.modelo.Cargo;
import com.gestion.cargos.repositorio.CargoRepositorio;
import com.gestion.cargos.servicios.interfaz.CargoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CargoServicioImpl implements CargoServicio {

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @Override
    public List<CargoDTO> findAll() {

        Iterable<Cargo> cargos = this.cargoRepositorio.findAll();
        List<CargoDTO> cargoDtos = new ArrayList<>();
        for (Cargo cargo: cargos) {
           CargoDTO cargoDto = MHelpers.modelMapper().map(cargo, CargoDTO.class);
           cargoDtos.add(cargoDto);
        }

        return cargoDtos;
    }

    @Override
    public CargoDTO findByIdCargo(Long cargoId) {
        Cargo cargo = this.cargoRepositorio.findByIdCargo(cargoId);
        return MHelpers.modelMapper().map(cargo, CargoDTO.class);
    }

    @Override
    public void save(CargoRequest request) {
         Cargo cargo = MHelpers.modelMapper().map(request, Cargo.class);

         this.cargoRepositorio.save(cargo);
    }

    @Override
    public void update(Long cargoId, CargoRequest request) {
        Optional<Cargo> cargo = this.cargoRepositorio.findById(cargoId);

        Cargo uCargo = cargo.get();

        uCargo.setEstadoCargo(request.getEstadoCargo());
        uCargo.setPuntoId(request.getPuntoId());
        uCargo.setUnidadOrganizativaId(request.getUnidadOrganizativaId());
        uCargo.setTransfCreacionId(request.getTransfCreacionId());
        uCargo.setTransfSupresionId(request.getTransfSupresionId());

        this.cargoRepositorio.save(uCargo);
    }
}
