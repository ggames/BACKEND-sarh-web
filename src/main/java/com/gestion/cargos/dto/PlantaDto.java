package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;
import com.gestion.cargos.modelo.EstadoPlanta;
import com.gestion.cargos.modelo.Punto;
import java.util.Date;

import lombok.Data;
@Data
public class PlantaDto {

	private Long id;

	private String caracter;

	private Cargo cargoId;

	private EstadoPlanta estadoPlantaId;

	private Agente agenteId;

	private Date fechaMovimiento;

	private String motivoMovimiento;
	
	private Date createdAt;

	private Date updateAt;



}
