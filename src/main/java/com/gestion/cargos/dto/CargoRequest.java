package com.gestion.cargos.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoRequest {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("idCargo")
	private Long idCargo;
	@JsonProperty("unidadOrganizativaId")
	private UnidadOrganizativa unidadOrganizativaId;

	@JsonProperty("puntoId")
	private Punto puntoId;

	@JsonProperty("estadoCargo")
	private EstadoCargo estadoCargo;
    @JsonProperty("caracter")
	private CargoCaracter caracter;

	@JsonProperty("transfCreacionId")
	private Transformacion transfCreacionId;

	@JsonProperty("transfSupresionId")
	private Transformacion transfSupresionId;

	@JsonProperty("plantas")
	private List<Planta> plantas = new ArrayList<>();
	@JsonProperty("createdAt")
	private Date createdAt;

    @JsonProperty("updatedAt")
	private Date updatedAt;

}
