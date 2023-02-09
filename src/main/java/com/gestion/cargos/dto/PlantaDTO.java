package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;

import java.util.Date;

import lombok.Data;
@Data
public class PlantaDTO {

	private Long id;

	private String caracter;

	private Cargo cargoId;

	private Agente agenteId;

	private Date fechaMovimiento;

	private String motivoMovimiento;

	private String resolucionInicio;

	private Date fechaInicio;

	private String resolucionFin;

	private Date fechaFin;

	private Date createdAt;

	private Date updateAt;



}
