package com.gestion.cargos.dto;

import com.gestion.cargos.enums.ECargoNombre;
import lombok.Data;

@Data
public class EstadoCargoDTO {

    private Long id;
    private ECargoNombre estadoCargo;

    private String nombre;
}
