package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.HistoriaPlantaDto;
import com.gestion.cargos.dto.HistoriaPlantaRequest;
import com.gestion.cargos.modelo.HistoriaPlanta;
import com.gestion.cargos.repositorio.HistoriaPlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.HistoriaPlantaServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HistoriaPlantaServicioImpl implements HistoriaPlantaServicio {

    @Autowired
    private HistoriaPlantaRepositorio historiaPlantaRepositorio;

    @Override
    public List<HistoriaPlantaDto> findAll() {

        Iterable<HistoriaPlanta> historias = this.historiaPlantaRepositorio.findAll();
        List<HistoriaPlantaDto>historiasDTO = new ArrayList<>();

        for (HistoriaPlanta historia: historias) {
            HistoriaPlantaDto dto = MHelpers.modelMapper().map(historia, HistoriaPlantaDto.class);
            historiasDTO.add(dto);
        }

        return historiasDTO;
    }

    @Override
    public HistoriaPlantaDto findByHistoriaPlantaId(Long id) {

        Optional<HistoriaPlanta> historiaPlanta = this.historiaPlantaRepositorio.findById(id);

        return MHelpers.modelMapper().map(historiaPlanta, HistoriaPlantaDto.class);
    }

    @Override
    public void save(HistoriaPlantaRequest request) {
         HistoriaPlanta historiaPlanta = MHelpers.modelMapper().map(request, HistoriaPlanta.class);

         this.historiaPlantaRepositorio.save(historiaPlanta);
    }

    @Override
    public void update(Long id, HistoriaPlantaRequest request) {
          Optional<HistoriaPlanta> historia = this.historiaPlantaRepositorio.findById(id);
          HistoriaPlanta uHistoria = historia.get();
          uHistoria.setPlantaId(request.getPlantaId());
          uHistoria.setEstadoPlantaId(request.getEstadoPlantaId());
          uHistoria.setResolucionInicio(request.getResolucionInicio());
          uHistoria.setFechaInicio(request.getFechaInicio());
          uHistoria.setResolucionFin(request.getResolucionFin());
          uHistoria.setFechaFin(request.getFechaFin());

          this.historiaPlantaRepositorio.save(uHistoria);
    }

    @Override
    public void delete(Long id) {

          this.historiaPlantaRepositorio.deleteById(id);

    }

    @Override
    public boolean existHistoriaPlantaId(Long id) {
        return this.historiaPlantaRepositorio.existsById(id);
    }
}
