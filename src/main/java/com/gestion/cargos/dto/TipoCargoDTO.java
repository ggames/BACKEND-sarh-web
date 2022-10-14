package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Punto;
import lombok.Data;

import java.util.List;

@Data
public class TipoCargoDTO {

    private Long id;

    private String cargo;

    private Double basico;

    private int cantidad_puntos;

    private List<Punto> puntos;
}
