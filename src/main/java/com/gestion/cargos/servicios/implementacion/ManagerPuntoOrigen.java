package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoOrigenDTO;
import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.PuntoOrigen;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.repositorio.PuntoOrigenRepositorio;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import com.gestion.cargos.servicios.interfaz.PuntoOrigenServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ManagerPuntoOrigen {

    Logger logger = LoggerFactory.getLogger(ManagerPuntoOrigen.class);
    @Autowired
    TipoCargoServicioImpl tipoCargoServicio;
    @Autowired
    PuntoOrigenServicio puntoOrigenServicio;
    @Autowired
    PuntoRepositorio puntoRepositorio;

    public void actualizarPuntoOrigenOcupado(TipoCargo tipo, int cantidad) {

        List<PuntoOrigenDTO> pto_origenes = this.puntoOrigenServicio.findAll();
        List<Punto> puntos = this.puntoRepositorio.findAll();

            pto_origenes.forEach(origen -> {
                   puntos.forEach(pto -> {

                                    // Despues de filtrar comparo el tipo de Cargo y actualizo en base a los
                                    // puntos que le corresponde por el tipo de cargo

                                    if (origen.getPuntoOrigenId() == pto.getId()
                                            && tipo.getId() == pto.getTipo_cargo().getId()) {
                                        // Convierte la cantidad de puntos del tipo de cargo a double
                                        BigDecimal tipo_pto_cant = new BigDecimal(tipo.getCantidad_puntos());
                                        tipo_pto_cant = tipo_pto_cant.setScale(2, RoundingMode.DOWN);
                                        double tipo_pto_double = tipo_pto_cant.doubleValue();

                                        // convierte la cantidad de puntos dispnibles en double
                                        BigDecimal pto_ocupado = new BigDecimal(origen.getCantOcupados());
                                        pto_ocupado = pto_ocupado.setScale(2, RoundingMode.DOWN);
                                        double pto_ocupado_double = pto_ocupado.doubleValue();

                                        // Cociente entre los puntos ocupados y la cantidad de puntos del Tipo de cargp
                                        double razon_pto = pto_ocupado_double / tipo_pto_double;

                                        // Calcula el nuevo punto despues de la actualizacion por paritaria
                                        int cant = (int) Math.round(razon_pto * cantidad);

                                        logger.error("ID " + origen.getPuntoOrigenId() + "  COCIENTE ORIGEN " + razon_pto + "  Nuevo PUNTOS OCUPADOS  " + cant);

                                        // Actualizo cada cantidad de ptos ocupados por cada punto de origen de acuerdo al tipo de cargo
                                        this.puntoOrigenServicio.updatePuntosOcupados(origen.getId(), cant);

                                    }

                                });


            } );


    }

    public void eliminarPuntosOrigenByPunto(Punto punto){

        List<PuntoOrigenDTO> pto_origenes = this.puntoOrigenServicio.findAll();

        pto_origenes.forEach(origen -> {
            if(origen.getPuntoOrigenId() == punto.getId() && punto.isTransitorio() == true){
                 puntoOrigenServicio.deletePuntoOrigen(origen.getId());
            }
        });

    }

   /* public void actualizarPuntoOrigenOcupado_total() {
                                                        
        List<PuntoOrigenDTO> pto_origenes = this.puntoOrigenServicio.findAll();
        List<TipoCargoDTO> tipoCargos = this.tipoCargoServicio.findAll();
        List<Punto> puntos = this.puntoRepositorio.findAll();

        tipoCargos.forEach(tipo -> {
            pto_origenes.forEach(origen -> {

                puntos.stream()
                        // Filtro cada
                        .filter(punto -> (punto.getId() == origen.getPuntoOrigenId())).forEach(
                                pto -> {
                                    if (tipo.getId() == pto.getTipo_cargo().getId()) {
                                        // Convierte la cantidad de puntos del tipo de cargo a double
                                        BigDecimal tipo_pto_cant = new BigDecimal(tipo.getCantidad_puntos());
                                        tipo_pto_cant = tipo_pto_cant.setScale(2, RoundingMode.DOWN);
                                        double tipo_pto_double = tipo_pto_cant.doubleValue();

                                        // convierte la cantidad de puntos dispnibles en double
                                        BigDecimal pto_ocupado = new BigDecimal(origen.getCantOcupados());
                                        pto_ocupado = pto_ocupado.setScale(2, RoundingMode.DOWN);
                                        double pto_ocupado_double = pto_ocupado.doubleValue();

                                        // Cociente entre los puntos ocupados y la cantidad de puntos del Tipo de cargp
                                        double razon_pto = pto_ocupado_double / tipo_pto_double;

                                        // Calcula el nuevo punto despues de la actualizacion por paritaria
                                        int cant = (int) Math.round(razon_pto * origen.getCantOcupados());

                                        // Actualizo cada cantidad de ptos ocupados por cada punto de origen de acuerdo al tipo de cargo
                                        this.puntoOrigenServicio.updatePuntosOcupados(origen.getPuntoOrigenId(), cant);

                                    }

                                }
                        );

            });
        });

    }*/


}
