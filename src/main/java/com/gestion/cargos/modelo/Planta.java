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
	
	private String caracter;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargoId;
	
	@ManyToOne
	@JoinColumn(name="estado_planta_id")
	private EstadoPlanta estadoPlantaId;
	
	@ManyToOne
	@JoinColumn(name = "agente_id")
	private Agente agenteId;

	private Date fechaMovimiento;

	private String motivoMovimiento;

	@JsonIgnoreProperties("plantaId")
	@OneToMany(mappedBy = "plantaId", cascade = CascadeType.ALL)
	private List<DetallePlanta> detallePlantas = new ArrayList<>();

	private Date createdAt;
	
	private Date updateAt;

	public Planta(String caracter, Cargo cargoId, EstadoPlanta estadoPlantaId, Agente agenteId, Date fechaMovimiento, String motivoMovimiento) {
		this.caracter = caracter;
		this.cargoId = cargoId;
		this.estadoPlantaId = estadoPlantaId;
		this.agenteId = agenteId;
		this.fechaMovimiento = fechaMovimiento;
		this.motivoMovimiento = motivoMovimiento;
	}

	public Planta() {
	}

}
