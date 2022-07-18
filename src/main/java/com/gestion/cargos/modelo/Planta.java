package com.gestion.cargos.modelo;

import lombok.Data;

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

	private Date createdAt;
	
	private Date updateAt;

		
}
