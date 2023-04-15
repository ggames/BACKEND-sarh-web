package com.gestion.cargos.servicios.implementacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gestion.cargos.dto.IndicePorcentajeRequest;
import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.dto.TipoCargoRequest;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.repositorio.TipoCargoRepositorio;
import com.gestion.cargos.servicios.interfaz.TipoCargoServicio;
import com.gestion.cargos.utils.MHelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class TipoCargoServicioImpl implements TipoCargoServicio {

    Logger logger = LoggerFactory.getLogger(TipoCargoServicioImpl.class);
    @Autowired
    TipoCargoRepositorio tipoCargoRepositorio;

    @Autowired
    PuntosManager puntosManager;

    @Autowired
    ManagerPuntoOrigen managerPuntoOrigen;

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



        logger.info( "CODIGO TIPO DE CARGO " + tipocargo.get().getCantidad_puntos() );

        /*
        *   ACTUALIZO TODOS LOS PUNTOS DISPONIBLES DISPONIBLE DE MANERA INDIVIDUAL DE ACUERDO
        *   AL TIPO DE CARGO ASIGNADO
        * */
        this.puntosManager.ActualizarPuntosDisponiblesParitaria(tipocargo.get() , request.getCantidad_puntos());
        this.managerPuntoOrigen.actualizarPuntoOrigenOcupado(tipocargo.get(), request.getCantidad_puntos());

        TipoCargo uTipoCargo = tipocargo.get();

        uTipoCargo.setBasico(request.getBasico());
        uTipoCargo.setCargo(request.getCargo());
        uTipoCargo.setCantidad_puntos(request.getCantidad_puntos());

        this.tipoCargoRepositorio.save(uTipoCargo);
    }
    @Override
    public void updateAll(List<TipoCargo> tiposCargos,  IndicePorcentajeRequest request) {

        tiposCargos.forEach(tcargo ->  {

            BigDecimal basico = new BigDecimal(tcargo.getBasico());
            basico = basico.setScale(2, RoundingMode.DOWN);

            double basico_ant = basico.doubleValue();


            Double basicoActual = (double)( basico_ant*request.getPorcentaje());

            BigDecimal basico_act = new BigDecimal(basicoActual);
            basico_act = basico_act.setScale(2, RoundingMode.DOWN);

            double basico_nuevo = basico_act.doubleValue();

            int nueva_cant_puntos = (int) Math.round(basico_nuevo/request.getIndice());

            /*
            *   ACTUALIZO TODOS LOS PUNTOS DISPONIBLES DE ACUERDO AL TIPO DE CARGO ASIGNADO
            * */

            this.puntosManager.ActualizarPuntosDisponiblesParitaria(tcargo, nueva_cant_puntos);
        //    this.managerPuntoOrigen.actualizarPuntoOrigenOcupado(tcargo, nueva_cant_puntos);

            tcargo.setBasico(basico_nuevo);
            tcargo.setCantidad_puntos(nueva_cant_puntos);


            this.tipoCargoRepositorio.save(tcargo);
        } );

    }

    @Override
    public boolean existTipoCargo(Long id) {
        return this.tipoCargoRepositorio.existsById(id);
    }
}
