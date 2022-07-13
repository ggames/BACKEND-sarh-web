package com.gestion.cargos.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestion.cargos.modelo.TipoDocumento;


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

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDocumento getTipoDocId() {
		return tipoDocId;
	}

	public void setTipoDocId(TipoDocumento tipoDocId) {
		this.tipoDocId = tipoDocId;
	}


	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	
}
