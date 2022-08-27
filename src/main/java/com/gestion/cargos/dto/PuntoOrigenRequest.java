package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Punto;
import lombok.Data;

@Data
public class PuntoOrigenRequest {
    @JsonProperty("puntoOrigenId")
    private Long puntoOrigenId;

    @JsonProperty("puntoId")
    private Punto puntoId;

    @JsonProperty("cantOcupados")
    private int cantOcupados;

}
