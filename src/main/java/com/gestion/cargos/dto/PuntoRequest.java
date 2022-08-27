package com.gestion.cargos.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.gestion.cargos.modelo.PuntoOrigen;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PuntoRequest {

	@JsonProperty("codigoCargo")
	private String codigoCargo;

	@JsonProperty("nombreCargo")
	private String nombreCargo;

	@JsonProperty("dedicacionCargo")
	private String dedicacionCargo;

	@JsonProperty("cantidad_puntos")
	private int cantidad_puntos;

	@JsonProperty("origenes")
	private List<PuntoOrigenRequest> origenes = new ArrayList<>();

}
