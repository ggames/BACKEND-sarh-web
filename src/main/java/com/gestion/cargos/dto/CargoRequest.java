package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.Transformacion;
import com.gestion.cargos.modelo.UnidadOrganizativa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoRequest {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("unidad_organizativa_id")
	private UnidadOrganizativa unidadOrganizativaId;

	@JsonProperty("punto_id")
	private Punto puntoId;

	@JsonProperty("estado_cargo")
	private String estadoCargo;

	@JsonProperty("transf_creacion_id")
	private Transformacion transfCreacionId;

	@JsonProperty("transf_supresion_id")
	private Transformacion transfSupresionId;

	@JsonProperty("created_at")
	private Date createdAt;

    @JsonProperty("updated_at")
	private Date updatedAt;

}
