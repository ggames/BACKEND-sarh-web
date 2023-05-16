package com.gestion.cargos.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransformacionDTO {

	private long id;
	
	private String numeroResolucion;
	
	private int resultadoTransformacion;
	
	private Date createdAt;
	
	private Date updateAt;


	

}
