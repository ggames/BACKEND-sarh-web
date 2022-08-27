package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.cargos.modelo.Punto;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class PuntoOrigenDTO {

    private Long id;
    private Long puntoOrigenId;
    private Punto puntoId;
    private int cantOcupados;
}
