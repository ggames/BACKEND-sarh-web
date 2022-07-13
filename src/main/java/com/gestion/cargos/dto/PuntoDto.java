package com.gestion.cargos.dto;

import java.util.Date;

public class PuntoDto {

	private Long id;
	
	private String codigoCargo;
	
	private String nombreCargo;
	
	private int dedicacionCargo;
	
	private int punto;

	private Date createdAt;
	
	private Date updatedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getDedicacionCargo() {
		return dedicacionCargo;
	}

	public void setDedicacionCargo(int dedicacionCargo) {
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
