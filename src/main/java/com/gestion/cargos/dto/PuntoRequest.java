package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.TipoCargo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PuntoRequest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("codPunto")
	private Long codPunto;
	@JsonProperty("tipo_cargo")
	private TipoCargo tipo_cargo;

	@JsonProperty("puntos_disponibles")
	private int puntos_disponibles;

	@JsonProperty("puntos_faltantes")
	private int puntos_faltantes;

	@JsonProperty("transitorio")
	private boolean transitorio;
	@JsonProperty("origenes")
	private List<PuntoOrigenRequest> origenes = new ArrayList<>();

}
