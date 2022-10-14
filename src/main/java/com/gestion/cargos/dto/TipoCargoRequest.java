package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Punto;
import lombok.Data;

import java.util.List;

@Data
public class TipoCargoRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("cargo")
    private String cargo;

    @JsonProperty("basico")
    private Double basico;

    @JsonProperty("cantidad_puntos")
    private int cantidad_puntos;

    private List<Punto> puntos;
}
