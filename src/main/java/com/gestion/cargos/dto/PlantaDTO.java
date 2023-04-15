package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.modelo.Cargo;

import java.util.Date;

import com.gestion.cargos.modelo.SubunidadOrganizativa;
import lombok.Data;
@Data
public class PlantaDTO {

	private Long id;

	private Cargo cargoId;

	private Agente agenteId;


	private SubunidadOrganizativa subunidadOrganizativaId;

	private Date fechaMovimiento;

	private String motivoMovimiento;

	private String resolucionInicio;

	private Date fechaInicio;

	private String resolucionFin;

	private Date fechaFin;

	private Date lic_Desde;

	private Date lic_Hasta;

	private Date fechaCese;

	private Date createdAt;

	private Date updateAt;



}
