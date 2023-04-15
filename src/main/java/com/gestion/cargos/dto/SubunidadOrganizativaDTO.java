package com.gestion.cargos.dto;

import java.util.Date;

import com.gestion.cargos.modelo.UnidadOrganizativa;
import lombok.Data;

@Data
public class SubunidadOrganizativaDTO {

	private Long id;

	private int codigoGuarani;

	private String nombre;

	private UnidadOrganizativa unidadOrganizativaId;

	private Date createdAt;

	private Date updatedAt;


}
