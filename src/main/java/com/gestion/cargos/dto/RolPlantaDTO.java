package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.modelo.SubunidadOrganizativa;
import lombok.Data;

@Data
public class RolPlantaDTO {
    private Long id;
    private String tipoRol;
    private SubunidadOrganizativa subunidadOrganizativaId;
    private Planta plantaId;
}
