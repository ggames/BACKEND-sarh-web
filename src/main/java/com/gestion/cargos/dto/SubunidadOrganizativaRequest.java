package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.UnidadOrganizativa;

public class SubunidadOrganizativaRequest {
	
	@JsonProperty("id")
	private Long id;

    @JsonProperty("codigoGuarani")
	private int codigoGuarani;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("unidadOrganizativaId")
    private UnidadOrganizativa unidadOrganizativaId;

    @JsonProperty("createdAt")
	private Date createdAt;

    @JsonProperty("updatedAt")
    private Date updatedAt;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoGuarani() {
		return codigoGuarani;
	}

	public void setCodigoGuarani(int codigoGuarani) {
		this.codigoGuarani = codigoGuarani;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public UnidadOrganizativa getUnidadOrganizativaId() {
		return unidadOrganizativaId;
	}

	public void setUnidadOrganizativaId(UnidadOrganizativa unidadOrganizativaId) {
		this.unidadOrganizativaId = unidadOrganizativaId;
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
