package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantaRequest {

	@JsonProperty("caracter")
	private String caracter;

	@JsonProperty("punto_id")
	private int puntoId;

	@JsonProperty("estado_planta_id")
	private int estadoPlantaId;

	@JsonProperty("agente_id")
	private int agenteId;

    @JsonProperty("created_at")
	private Date createdAt;

    @JsonProperty("updated_at")
	private Date updateAt;

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public int getPuntoId() {
		return puntoId;
	}

	public void setPuntoId(int puntoId) {
		this.puntoId = puntoId;
	}

	public int getEstadoPlantaId() {
		return estadoPlantaId;
	}

	public void setEstadoPlantaId(int estadoPlantaId) {
		this.estadoPlantaId = estadoPlantaId;
	}

	public int getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(int agenteId) {
		this.agenteId = agenteId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

    
}
