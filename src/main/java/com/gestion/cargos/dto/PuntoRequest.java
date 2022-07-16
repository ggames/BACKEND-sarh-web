package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuntoRequest {

	@JsonProperty("id")
	private String id;

	@JsonProperty("codigo_cargo")
	private String codigoCargo;

	@JsonProperty("nombre_cargo")
	private String nombreCargo;

	@JsonProperty("dedicacion_cargo")
	private String dedicacionCargo;

	@JsonProperty("puntos")
	private int puntos;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

}
