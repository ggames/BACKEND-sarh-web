package com.gestion.cargos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformacionRequest {
    
	@JsonProperty("id")
	private long id;
	
    @JsonProperty("numero_resolucion")
	private String numeroResolucion;
	
    @JsonProperty("resultado_transformacion")
	private int resultadoTransformacion;
	
    @JsonProperty("created_at")
	private Date createdAt;
	
    @JsonProperty("update_at")
	private Date updateAt;
    
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	public int getResultadoTransformacion() {
		return resultadoTransformacion;
	}

	public void setResultadoTransformacion(int resultadoTransformacion) {
		this.resultadoTransformacion = resultadoTransformacion;
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
