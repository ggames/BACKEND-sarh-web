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
@Table(name= "HistoriaPlanta", schema = "cargos")
public class HistoriaPlanta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "planta_id")
	private Planta plantaId;
	
	@ManyToOne
	@JoinColumn(name = "estado_planta_id")
	private EstadoPlanta estadoPlantaId;
	
	private String resolucionInicio;

	private Date fechaInicio;
	
	private String resolucionFin;
	
	private Date fechaFin;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Planta getPlantaId() {
		return plantaId;
	}
	public void setPlantaId(Planta plantaId) {
		this.plantaId = plantaId;
	}
	public EstadoPlanta getEstadoPlantaId() {
		return estadoPlantaId;
	}
	public void setEstadoPlantaId(EstadoPlanta estadoPlantaId) {
		this.estadoPlantaId = estadoPlantaId;
	}
	public String getResolucionInicio() {
		return resolucionInicio;
	}
	public void setResolucionInicio(String resolucionInicio) {
		this.resolucionInicio = resolucionInicio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getResolucionFin() {
		return resolucionFin;
	}
	public void setResolucionFin(String resolucionFin) {
		this.resolucionFin = resolucionFin;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	

}
