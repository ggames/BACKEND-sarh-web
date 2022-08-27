package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.modelo.Transformacion;
import com.gestion.cargos.modelo.UnidadOrganizativa;
import lombok.Data;

import java.util.Date;


@Data
public class CargoDTO {

	private Long id;

	private UnidadOrganizativa unidadOrganizativaId;

	private Punto puntoId;

	private String estadoCargo;

	private Transformacion transfCreacionId;

	private Transformacion transfSupresionId;

	private Date createdAt;

	private Date updatedAt;


}
