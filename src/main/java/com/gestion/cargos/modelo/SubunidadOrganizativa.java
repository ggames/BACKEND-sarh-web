package com.gestion.cargos.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubunidadOrganizativa", schema = "cargos")
public class SubunidadOrganizativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int codigoGuarani;
	
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "unidad_organizativa_id")
	private UnidadOrganizativa unidadOrganizativaId;
	
	private Date createdAt;
	
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

	public UnidadOrganizativa getUnidadOrganizacionalId() {
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
