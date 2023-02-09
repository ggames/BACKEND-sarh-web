package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Planta", schema = "cargos")
@Data
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	@JsonIgnoreProperties("plantas")
	private Cargo cargoId;


	@ManyToOne
	@JoinColumn(name = "agente_id")
	private Agente agenteId;

	private Date fechaMovimiento;

	private String motivoMovimiento;

	private String resolucionInicio;

	private Date fechaInicio;

	private String resolucionFin;

	private Date fechaFin;

	private Date createdAt;
	
	private Date updateAt;

	public Planta(Cargo cargoId, Agente agenteId, Date fechaMovimiento, String motivoMovimiento) {
		this.cargoId = cargoId;
		this.agenteId = agenteId;
		this.fechaMovimiento = fechaMovimiento;
		this.motivoMovimiento = motivoMovimiento;
	}

	public Planta() {
	}

}
