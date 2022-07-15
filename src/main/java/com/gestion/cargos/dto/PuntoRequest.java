package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PuntoRequest {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("codigo_cargo")
	private String codigoCargo;
	
	@JsonProperty("nombre_cargo")
	private String nombreCargo;
	
	@JsonProperty("dedicacion_cargo")
	private String dedicacionCargo;
    
	@JsonProperty("punto")
	private int punto;
    
	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public String getDedicacionCargo() {
		return dedicacionCargo;
	}

	public void setDedicacionCargo(String dedicacionCargo) {
		this.dedicacionCargo = dedicacionCargo;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
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
