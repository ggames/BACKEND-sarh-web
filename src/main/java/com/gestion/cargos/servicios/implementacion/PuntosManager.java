package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.PuntoOrigen;
import com.gestion.cargos.repositorio.PuntoOrigenRepositorio;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PuntosManager {

    @Autowired
    PuntoRepositorio puntoRepositorio;

    @Autowired
    PuntoOrigenRepositorio puntoOrigenRepositorio;
    public void ConfirmarCreacion(Punto punto) {

        List<PuntoOrigen> origenes = punto.getOrigenes();

        List<PuntoOrigen> nuevosOrigenes = new ArrayList<>();

        Punto nuevoPunto = new Punto(punto.getCodigoCargo(), punto.getNombreCargo(),
                punto.getDedicacionCargo(), punto.getCantidad_puntos());

        puntoRepositorio.save(nuevoPunto);





        for (PuntoOrigen origen : origenes) {

            PuntoOrigen origenAux = new PuntoOrigen(origen.getPuntoOrigenId(), origen.getCantOcupados());

            origenAux.setPuntoId(nuevoPunto);
            nuevosOrigenes.add(origenAux);

            Punto punto_origen = puntoRepositorio.findById(origen.getId()).get();

            int existencia = punto_origen.getCantidad_puntos() - origen.getCantOcupados();

            punto_origen.setCantidad_puntos(existencia);

            puntoRepositorio.save(punto_origen);
        }
        nuevoPunto.setOrigenes(nuevosOrigenes);
        puntoRepositorio.save(nuevoPunto);
    }

    public void ReestablecerPuntos(Punto punto) {

        List<PuntoOrigen> origenes = punto.getOrigenes();

        if (punto != null) {
            if (origenes.size() <= 0 || origenes.isEmpty()) {
                for (PuntoOrigen origen : origenes) {
                    Punto punto_origen = puntoRepositorio.findById(origen.getId()).get();
                    punto_origen.setCantidad_puntos(punto_origen.getCantidad_puntos() + origen.getCantOcupados());

                    puntoRepositorio.save(punto_origen);
                }
            }
            puntoRepositorio.deleteById(punto.getId());
        }
    }

}
