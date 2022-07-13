package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CargoRequest {
	
	@JsonProperty("punto_id")
	private int puntoId;
	
	@JsonProperty("estado_cargo")
	private String estadoCargo;

	@JsonProperty("transf_creacion_id")
	private int transfCreacionId;

	@JsonProperty("transf_supresion_id")
	private int transfSupresionId;

	@JsonProperty("created_at")
	private Date createdAt;

    @JsonProperty("updated_at")
	private Date updatedAt;

	public int getPuntoId() {
		return puntoId;
	}

	public void setPuntoId(int puntoId) {
		this.puntoId = puntoId;
	}

	public String getEstadoCargo() {
		return estadoCargo;
	}

	public void setEstadoCargo(String estadoCargo) {
		this.estadoCargo = estadoCargo;
	}

	public int getTransfCreacionId() {
		return transfCreacionId;
	}

	public void setTransfCreacionId(int transfCreacionId) {
		this.transfCreacionId = transfCreacionId;
	}

	public int getTransfSupresionId() {
		return transfSupresionId;
	}

	public void setTransfSupresionId(int transfSupresionId) {
		this.transfSupresionId = transfSupresionId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
