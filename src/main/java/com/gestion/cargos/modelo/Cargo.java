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
@Table(name="Cargo", schema = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "unidad_organizacional_id")
	private UnidadOrganizativa unidadOrganizativaId;

	@ManyToOne
	@JoinColumn(name = "punto_id")
	private Punto puntoId;
	
	private String estadoCargo;
	
	@ManyToOne
	@JoinColumn(name = "transf_creacion_id")
	private Transformacion transfCreacionId;
	
	@ManyToOne
	@JoinColumn(name = "transf_supresion_id")
	private Transformacion transfSupresionId;
	
	private Date createdAt;
	
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UnidadOrganizativa getUnidadOrganizacionId() {
		return unidadOrganizativaId;
	}

	public void setUnidadOrganizacionId(UnidadOrganizativa unidadOrganizativaId) {
		this.unidadOrganizativaId = unidadOrganizativaId;
	}

	public Punto getPuntoId() {
		return puntoId;
	}

	public void setPuntoId(Punto puntoId) {
		this.puntoId = puntoId;
	}

	public String getEstadoCargo() {
		return estadoCargo;
	}

	public void setEstadoCargo(String estadoCargo) {
		this.estadoCargo = estadoCargo;
	}

	public Transformacion getTransfCreacionId() {
		return transfCreacionId;
	}

	public void setTransfCreacionId(Transformacion transfCreacionId) {
		this.transfCreacionId = transfCreacionId;
	}

	public Transformacion getTransfSupresionId() {
		return transfSupresionId;
	}

	public void setTransfSupresionId(Transformacion transfSupresionId) {
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
