package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.PuntoOrigen;
import com.gestion.cargos.modelo.TipoCargo;
import com.gestion.cargos.repositorio.PuntoOrigenRepositorio;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PuntosManager {

    Logger logger = LoggerFactory.getLogger(PuntosManager.class);
    @Autowired
    PuntoServicioImpl puntoServicio;

    @Autowired
    PuntoRepositorio puntoRepositorio;
    @Autowired
    PuntoOrigenRepositorio puntoOrigenRepositorio;

    // Funcion que actualiza los puntos que no han sido afectados para crear otros puntos nuevos

    public void ActualizarPuntosDisponiblesParitaria(TipoCargo tipoC, int cantidad){

        List<Punto> lista_puntos = this.puntoServicio.findAllPuntos();
               if(tipoC != null) {
            if(!lista_puntos.isEmpty()){
                lista_puntos.forEach(pto ->{
                   if(tipoC.getId() == pto.getTipo_cargo().getId())
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
                       double razon_ptos = ptoDisponible/ ptoTipo;

                       int cant = (int)Math.round(razon_ptos * cantidad);
                      logger.info("COCIENTE " + cant);

                       this.puntoServicio.updatePuntosParitaria(pto.getId(), cantidad);
                   }
                });
            }
        }

    }

    public void ReestablecerPuntos(Punto punto) {

        List<PuntoOrigen> origenes = punto.getOrigenes();

        if (punto != null) {
            if (origenes.size() <= 0 || origenes.isEmpty()) {
                for (PuntoOrigen origen : origenes) {
                    Punto punto_origen = puntoServicio.findById(origen.getId());
                    if(punto_origen != null)
                      punto_origen.setPuntos_disponibles(punto_origen.getPuntos_disponibles() + origen.getCantOcupados());

                    puntoRepositorio.save(punto_origen);
                }
            }
            puntoRepositorio.deleteById(punto.getId());
        }
    }

}
