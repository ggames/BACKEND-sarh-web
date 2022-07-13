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
@Table(name="RolPlanta", schema = "cargos")
public class RolPlanta {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String tipoRol;
    
    @ManyToOne
    @JoinColumn(name = "subunidad_organizacional_id")
	private SubunidadOrganizativa subunidadOrganizacionalId;
    
    @ManyToOne
    @JoinColumn(name = "planta_id")
    private Planta plantaId;
    
    private Date createdAt;
    
    private Date updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public SubunidadOrganizativa getSubunidadOrganizacionalId() {
		return subunidadOrganizacionalId;
	}

	public void setSubunidadOrganizacionalId(SubunidadOrganizativa subunidadOrganizacionalId) {
		this.subunidadOrganizacionalId = subunidadOrganizacionalId;
	}

	public Planta getPlantaId() {
		return plantaId;
	}

	public void setPlantaId(Planta plantaId) {
		this.plantaId = plantaId;
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
