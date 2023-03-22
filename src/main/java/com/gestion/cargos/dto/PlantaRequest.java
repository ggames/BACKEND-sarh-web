package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;
import lombok.Data;

import java.util.Date;

@Data
public class PlantaRequest {

	@JsonProperty("id")
	private Long id;

	//@JsonProperty("caracter")
	//private String caracter;

	@JsonProperty("cargoId")
	private Cargo cargoId;

	@JsonProperty("agenteId")
	private Agente agenteId;

	@JsonProperty("fechaMovimiento")
	private Date fechaMovimiento;

	@JsonProperty("motivoMovimiento")
	private String motivoMovimiento;

	@JsonProperty("resolucionInicio")
	private String resolucionInicio;

	@JsonProperty("fechaInicio")
	private Date fechaInicio;

	@JsonProperty("resolucionFin")
	private String resolucionFin;

	@JsonProperty("fechaFin")
	private Date fechaFin;


}
