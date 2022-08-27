package com.gestion.cargos.dto;

import com.gestion.cargos.security.enums.RolNombre;
import lombok.Data;

@Data
public class RolDTO {

    private RolNombre rolNombre;

    private String nombre;
}
