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
@Table(name = "Planta", schema = "cargos")
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String caracter;
	
	@ManyToOne
	@JoinColumn(name = "punto_id")
	private Punto puntoId;
	
	@ManyToOne
	@JoinColumn(name="estado_planta_id")
	private EstadoPlanta estadoPlantaId;
	
	@ManyToOne
	@JoinColumn(name = "agente_id")
	private Agente agenteId;
	
	private Date createdAt;
	
	private Date updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public Punto getPuntoId() {
		return puntoId;
	}

	public void setPuntoId(Punto puntoId) {
		this.puntoId = puntoId;
	}

	public EstadoPlanta getEstadoPlantaId() {
		return estadoPlantaId;
	}

	public void setEstadoPlantaId(EstadoPlanta estadoPlantaId) {
		this.estadoPlantaId = estadoPlantaId;
	}

	public Agente getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Agente agenteId) {
		this.agenteId = agenteId;
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
