package com.gestion.cargos.dto;

import com.gestion.cargos.enums.RolNombre;
import lombok.Data;

@Data
public class RolDTO {

    private RolNombre rolNombre;

    private String nombre;
}
