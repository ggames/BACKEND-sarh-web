package com.gestion.cargos.dto;

import java.util.Date;

public class UnidadOrganizativaDto {

	private Long id;

	private String nombre;

	private int directorId;

	private int viceDirectorId;

	private Date createdAt;

	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public int getViceDirectorId() {
		return viceDirectorId;
	}

	public void setViceDirectorId(int viceDirectorId) {
		this.viceDirectorId = viceDirectorId;
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
