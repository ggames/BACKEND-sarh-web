package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.DetallePlantaDTO;
import com.gestion.cargos.dto.DetallePlantaRequest;
import com.gestion.cargos.modelo.DetallePlanta;
import com.gestion.cargos.repositorio.DetallePlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.DetallePlantaServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DetallePlantaServicioImpl implements DetallePlantaServicio {

    @Autowired
    private DetallePlantaRepositorio detallePlantaRepositorio;

    @Override
    public List<DetallePlantaDTO> findAll() {

        Iterable<DetallePlanta> detallesPlanta = this.detallePlantaRepositorio.findAll();
        List<DetallePlantaDTO>detallePlantaDTO = new ArrayList<>();

        for (DetallePlanta detalle: detallesPlanta) {
            DetallePlantaDTO dto = MHelpers.modelMapper().map(detalle, DetallePlantaDTO.class);
            detallePlantaDTO.add(dto);
        }

        return detallePlantaDTO;
    }

    @Override
    public DetallePlantaDTO findByDetallePlantaId(Long id) {

        Optional<DetallePlanta> detallePlanta = this.detallePlantaRepositorio.findById(id);

        return MHelpers.modelMapper().map(detallePlanta, DetallePlantaDTO.class);
    }

    @Override
    public void save(DetallePlantaRequest request) {
         DetallePlanta detallePlanta = MHelpers.modelMapper().map(request, DetallePlanta.class);

         this.detallePlantaRepositorio.save(detallePlanta);
    }

    @Override
    public void update(Long id, DetallePlantaRequest request) {
          Optional<DetallePlanta> detallePlanta = this.detallePlantaRepositorio.findById(id);
          DetallePlanta uDetallePlanta = detallePlanta.get();
          uDetallePlanta.setPlantaId(request.getPlantaId());
          uDetallePlanta.setEstadoPlantaId(request.getEstadoPlantaId());
          uDetallePlanta.setResolucionInicio(request.getResolucionInicio());
          uDetallePlanta.setFechaInicio(request.getFechaInicio());
          uDetallePlanta.setResolucionFin(request.getResolucionFin());
          uDetallePlanta.setFechaFin(request.getFechaFin());

          this.detallePlantaRepositorio.save(uDetallePlanta);
    }

    @Override
    public void delete(Long id) {

          this.detallePlantaRepositorio.deleteById(id);

    }

    @Override
    public boolean existDetallePlantaId(Long id) {
        return this.detallePlantaRepositorio.existsById(id);
    }
}
