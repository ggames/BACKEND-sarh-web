package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.EstadoPlanta;
import com.gestion.cargos.modelo.Planta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePlantaRequest {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("planta_id")
    private Planta plantaId;

    @JsonProperty("estado_planta_id")
    private EstadoPlanta estadoPlantaId;

    @JsonProperty("resolucion_inicio")
    private String resolucionInicio;

    @JsonProperty("fecha_inicio")
    private Date fechaInicio;

    @JsonProperty("resolucion_fin")
    private String resolucionFin;

    @JsonProperty("fecha_fin")
    private Date fechaFin;
}