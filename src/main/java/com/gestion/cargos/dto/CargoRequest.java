package com.gestion.cargos.dto;

import java.util.Date;

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

	@JsonProperty("transf_creacion_id")
	private Transformacion transfCreacionId;

	@JsonProperty("transfSupresionId")
	private Transformacion transfSupresionId;

	@JsonProperty("createdAt")
	private Date createdAt;

    @JsonProperty("updatedAt")
	private Date updatedAt;

}
