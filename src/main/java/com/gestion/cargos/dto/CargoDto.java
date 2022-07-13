package com.gestion.cargos.dto;

import java.util.Date;



public class CargoDto {

	private Long id;

	private int unidadOrganizativaId;

	private int puntoId;

	private String estadoCargo;

	private int transfCreacionId;

	private int transfSupresionId;

	private Date createdAt;

	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUnidadOrganizativaId() {
		return unidadOrganizativaId;
	}

	public void setUnidadOrganizativaId(int unidadOrganizativaId) {
		this.unidadOrganizativaId = unidadOrganizativaId;
	}

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
