package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;
import com.gestion.cargos.modelo.EstadoPlanta;
import lombok.Data;

import java.util.Date;

@Data
public class PlantaRequest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("caracter")
	private String caracter;

	@JsonProperty("cargo_id")
	private Cargo cargoId;

	@JsonProperty("estado_planta_id")
	private EstadoPlanta estadoPlantaId;

	@JsonProperty("agente_id")
	private Agente agenteId;

	@JsonProperty("fecha_movimiento")
	private Date fechaMovimiento;

	@JsonProperty("motivo_movimiento")
	private String motivoMovimiento;

    @JsonProperty("created_at")
	private Date createdAt;

    @JsonProperty("updated_at")
	private Date updateAt;

}
