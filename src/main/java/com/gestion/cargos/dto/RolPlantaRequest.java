package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.modelo.SubunidadOrganizativa;
import lombok.Data;

@Data
public class RolPlantaRequest {

  @JsonProperty("id")
  private Long id;
  @JsonProperty("tipoRol")
  private String tipoRol;
  @JsonProperty("subunidadOrganizativaId")
  private SubunidadOrganizativa subunidadOrganizativaId;
  @JsonProperty("plantaId")
  private Planta plantaId;


}
