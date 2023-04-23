package com.gestion.cargos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;

	@Column(name="apellido", length = 45, nullable = false)
	private String apellido;
    
	@ManyToOne
	@JoinColumn(name = "tipo_doc_id", nullable = false)
	private TipoDocumento tipoDocId;

	@Column(nullable = false)
	private Integer documento;


	@Column(	columnDefinition = "boolean default false"
	)
	private Boolean esFallecido;

	@Column(name = "fecha_baja")
	private Date fechaBaja;

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

	public Agente(){}
}
