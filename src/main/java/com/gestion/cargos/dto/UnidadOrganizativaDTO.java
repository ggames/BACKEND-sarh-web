package com.gestion.cargos.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UnidadOrganizativaDTO {

	private Long id;

	private String nombre;

	private int directorId;

	private int viceDirectorId;

	private Date createdAt;

	private Date updatedAt;

}
