package com.gestion.cargos.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.TipoDocumento;
import lombok.Data;

@Data
public class AgenteRequest {
   
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("apellido")
	private String apellido;

	@JsonProperty("tipoDocId")
	private TipoDocumento tipoDocId;

	@JsonProperty("documento")
	private Integer documento;

	@JsonProperty("fechaNac")
	private Date fechaNac;

	@JsonProperty("legajo")
	private String legajo;

	@JsonProperty("email")
	private String email;

	@JsonProperty("telefono")
	private String telefono;

	@JsonProperty("domicilio")
	private String domicilio;


}
