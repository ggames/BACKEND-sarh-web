package com.gestion.cargos.dto;

import java.util.Date;

public class TransformacionDto {

	private long id;
	
	private String numeroResolucion;
	
	private int resultadoTransformacion;
	
	private Date createdAt;
	
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

	public void setNumeroResolucion(String numero_resolucion) {
		this.numeroResolucion = numero_resolucion;
	}

	public int getResultadoTransformacion() {
		return resultadoTransformacion;
	}

	public void setResultadoTransformacion(int resultado_transformacion) {
		this.resultadoTransformacion = resultado_transformacion;
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
