package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.dto.TipoCargoRequest;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.repositorio.TipoCargoRepositorio;
import com.gestion.cargos.servicios.interfaz.TipoCargoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class TipoCargoServicioImpl implements TipoCargoServicio {

    @Autowired
    TipoCargoRepositorio tipoCargoRepositorio;

    @Override
    public List<TipoCargoDTO> findAll() {
       List<TipoCargoDTO> tipocargosDTO = new ArrayList<>();
       Iterable<TipoCargo> tipocargos = tipoCargoRepositorio.findAll();

       for (TipoCargo tipo: tipocargos){
           TipoCargoDTO dto = MHelpers.modelMapper().map(tipo, TipoCargoDTO.class);
           tipocargosDTO.add(dto);
       }

        return tipocargosDTO;
    }

    @Override
    public TipoCargoDTO findByTipoCargoId(Long id) {
        Optional<TipoCargo> tipocargo = tipoCargoRepositorio.findById(id);
        if(!tipocargo.isPresent()){
           return null;
        }
        return MHelpers.modelMapper().map(tipocargo.get(), TipoCargoDTO.class);
    }

    @Override
    public void save(TipoCargoRequest request) {
         TipoCargo tipocargoAguardar = MHelpers.modelMapper().map(request, TipoCargo.class);

         this.tipoCargoRepositorio.save(tipocargoAguardar);
    }

    @Override
    public void update(Long id, TipoCargoRequest request) {
        Optional<TipoCargo> tipocargo = this.tipoCargoRepositorio.findById(id);

        TipoCargo uTipoCargo = tipocargo.get();

        uTipoCargo.setBasico(request.getBasico());
        uTipoCargo.setCargo(request.getCargo());
        uTipoCargo.setCantidad_puntos(request.getCantidad_puntos());

        this.tipoCargoRepositorio.save(uTipoCargo);
    }

    @Override
    public boolean existTipoCargo(Long id) {
        return this.tipoCargoRepositorio.existsById(id);
    }
}
