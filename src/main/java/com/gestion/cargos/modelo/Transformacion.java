package com.gestion.cargos.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transformacion", schema = "cargos")
public class Transformacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "numero_resolucion")
	private String numeroResolucion;
	
	@Column(name= "resultado_transformacion")
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
