package com.gestion.cargos.dto;

import com.gestion.cargos.enums.cCaracterNombre;
import lombok.Data;

@Data
public class CaracterDTO {

    private Long id;

    private cCaracterNombre cargoCaracter;

    private String nombre;
}
