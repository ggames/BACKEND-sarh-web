package com.gestion.cargos.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PuntoDto {

	private Long id;
	
	private String codigoCargo;
	
	private String nombreCargo;
	
	private String dedicacionCargo;
	
	private int puntos;

	private Date createdAt;
	
	private Date updatedAt;
	


}
