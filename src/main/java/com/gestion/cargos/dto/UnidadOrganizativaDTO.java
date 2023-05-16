package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.SubunidadOrganizativa;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UnidadOrganizativaDTO {

	private Long id;

	private String nombre;

	private int directorId;

	private int viceDirectorId;

	private Date createdAt;

	private Date updatedAt;

}
