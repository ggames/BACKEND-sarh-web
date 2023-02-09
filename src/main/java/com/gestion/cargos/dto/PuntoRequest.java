package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.TipoCargo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PuntoRequest {

	@JsonProperty("tipo_cargo_id")
	private TipoCargo tipo_cargo;

	@JsonProperty("puntos_disponibles")
	private int puntos_disponibles;

	@JsonProperty("transitorio")
	private boolean transitorio;
	@JsonProperty("origenes")
	private List<PuntoOrigenRequest> origenes = new ArrayList<>();

}
