package com.gestion.cargos.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Agente", schema = "cargos")
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;

	@Column(name="apellido", length = 45, nullable = false)
	private String apellido;
    
	@ManyToOne
	@JoinColumn(name = "tipo_doc_id", nullable = false)
	private TipoDocumento tipoDocId;

	@Column(nullable = false)
	private Integer documento;

	@Column(name="fecha_nac",nullable = false)
	private Date fechaNac;

	@Column(name="legajo",length = 45 , nullable = false)
	private String legajo;

	@Column(name="email", length = 150, nullable = true)
	private String email;

	@Column(length = 45, nullable = true)
	private String telefono;

	@Column(length = 45, nullable = true)
	private String domicilio;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public Agente() { }
	
	public Agente(String nombre, String apellido, TipoDocumento tipo_doc_id, Integer documento, Date fecha_nac,
			String legajo, String email, String telefono, String domicilio) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocId = tipo_doc_id;
		this.documento = documento;
		this.fechaNac = fecha_nac;
		this.legajo = legajo;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	



}
