package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.UnidadOrganizativa;
import lombok.Data;

@Data
public class SubunidadOrganizativaRequest {
	
	@JsonProperty("id")
	private Long id;

    @JsonProperty("codigoGuarani")
	private int codigoGuarani;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("unidadOrganizativaId")
    private UnidadOrganizativa unidadOrganizativaId;

    @JsonProperty("createdAt")
	private Date createdAt;

    @JsonProperty("updatedAt")
    private Date updatedAt;


}
