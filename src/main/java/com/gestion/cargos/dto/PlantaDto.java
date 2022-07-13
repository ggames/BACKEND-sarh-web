package com.gestion.cargos.dto;

import java.util.Date;


public class PlantaDto {

	private Long id;

	private String caracter;

	private int puntoId;

	private int estadoPlantaId;

	private int agenteId;
	
	private Date createdAt;

	private Date updateAt;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
