package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UnidadOrganizativaRequest {
  
	@JsonProperty("id")
	private Long id;

    @JsonProperty("nombre")
	private String nombre;

    @JsonProperty("directorId")
    private int directorId;

    @JsonProperty("viceDirectorId")   
	private int viceDirectorId;
    @JsonProperty("cargos")
    private List<Cargo> cargos = new ArrayList<>();

    

}
