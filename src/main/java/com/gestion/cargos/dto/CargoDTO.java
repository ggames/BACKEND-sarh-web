package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.*;
import lombok.Data;

import java.util.Date;


@Data
public class CargoDTO {

	private Long id;
	private Long idCargo;
	private UnidadOrganizativa unidadOrganizativaId;
	private Punto puntoId;
	private EstadoCargo estadoCargo;
	private CargoCaracter  caracter;
	private Transformacion transfCreacionId;

	private Transformacion transfSupresionId;

	private Date createdAt;

	private Date updatedAt;


}
