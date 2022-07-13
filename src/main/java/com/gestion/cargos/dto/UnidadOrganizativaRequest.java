package com.gestion.cargos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnidadOrganizativaRequest {
  
	@JsonProperty("id")
	private Long id;

    @JsonProperty("nombre")
	private String nombre;

    @JsonProperty("directorId")
    private int directorId;

    @JsonProperty("viceDirectorId")   
	private int viceDirectorId;

    
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

}
