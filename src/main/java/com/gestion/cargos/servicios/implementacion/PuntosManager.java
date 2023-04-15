package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.PuntoOrigen;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.repositorio.PuntoOrigenRepositorio;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import com.gestion.cargos.utils.MHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PuntosManager {

    Logger logger = LoggerFactory.getLogger(PuntosManager.class);
    @Autowired
    PuntoServicioImpl puntoServicio;

    @Autowired
    TipoCargoServicioImpl tipoCargoServicio;

    @Autowired
    PuntoRepositorio puntoRepositorio;
    @Autowired
    PuntoOrigenServicioImpl puntoOrigenServicio;
    //PuntoOrigenRepositorio puntoOrigenRepositorio;

    // Funcion que actualiza los puntos que no han sido afectados para crear otros puntos nuevos

    public void ActualizarPuntosDisponiblesParitaria(TipoCargo tipoC, int cantidad) {

        List<Punto> lista_puntos = this.puntoServicio.findAllPuntos();
        if (tipoC != null) {
            if (!lista_puntos.isEmpty()) {
                lista_puntos.forEach(pto -> {
                    if (tipoC.getId() == pto.getTipo_cargo().getId())
                    //        && tipoC.getCantidad_puntos() == pto.getPuntos_disponibles())
                    {
                        // convierte la cantidad de puntos del Tipo de cargo a double
                        BigDecimal pto_tipo = new BigDecimal(tipoC.getCantidad_puntos());
                        pto_tipo = pto_tipo.setScale(2, RoundingMode.DOWN);
                        double ptoTipo = pto_tipo.doubleValue();

                        // convierte la cantidad de puntos dispnibles en double
                        BigDecimal pto_disponible = new BigDecimal(pto.getPuntos_disponibles());
                        pto_disponible = pto_disponible.setScale(2, RoundingMode.DOWN);
                        double ptoDisponible = pto_disponible.doubleValue();

                        // Cociente entre los puntos disponibles y la cantidad de puntos del Tipo de cargp
                        double razon_ptos = ptoDisponible / ptoTipo;

                        int cant = (int) Math.round(razon_ptos * cantidad);
                        logger.error("COCIENTE " + razon_ptos + "  Nuevo PUNTOS " + cant);

                        this.puntoServicio.updatePuntosParitaria(pto.getId(), cant);
                    }
                });
            }
        }

    }

    public void ReestablecerPuntos(Long id) {

        Punto punto = this.puntoServicio.findById(id);

        Long tpcargo_id = punto.getTipo_cargo().getId();


        // Busco el tipo de cargo para saber los puntos asociados a él

        TipoCargoDTO tipocargo = this.tipoCargoServicio.findByTipoCargoId(tpcargo_id);

        if (punto != null) {
            List<PuntoOrigen> origenes = punto.getOrigenes();

            int cantidad_puntos = punto.getPuntos_disponibles();
//            this.puntoOrigenRepositorio.deleteById(34L);


            for (int i = 0; i < origenes.size(); i++) {
                //  // Busco los puntos que dieron origen al punto pasado por paramentro
                PuntoOrigen origen = origenes.get(i);

                Punto punto_generadoByPunto = puntoServicio.findById(origen.getPuntoOrigenId());

                logger.info("CANTIDAD DE PUNTOS ORIGENES " + origen.getId());
                //cantidad_puntos +=origen.getCantOcupados();

                int ptos_recuperados_original = punto_generadoByPunto.getPuntos_disponibles() + origen.getCantOcupados();

                punto_generadoByPunto.setPuntos_disponibles(ptos_recuperados_original);

                PuntoRequest request = MHelpers.modelMapper().map(punto_generadoByPunto, PuntoRequest.class);

                this.puntoServicio.update(request.getId(), request);
              //  this.puntoOrigenRepositorio.delete(origen);
                Long origen_id = origen.getId();
               // this.puntoOrigenRepositorio.deleteById(origen_id);

            }
            punto.setOrigenes(null);
            punto.setPuntos_disponibles(0);
            PuntoRequest request = MHelpers.modelMapper().map(punto, PuntoRequest.class);
            this.puntoServicio.update(request.getId(), request);
            this.puntoOrigenServicio.deletePuntoOrigen(id);
            // puntoRepositorio.deleteById(punto.getId());
        }
    }


}
