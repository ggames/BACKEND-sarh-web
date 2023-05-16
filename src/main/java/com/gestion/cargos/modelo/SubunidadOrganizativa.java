package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubunidadOrganizativa", schema = "cargos")
@Data
public class SubunidadOrganizativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigoGuarani;
	
	private String nombre;
	@ManyToOne(optional = false)
	@JoinColumn(name = "unidad_organizativa_id")
	@JsonIgnoreProperties("subunidades")
	private UnidadOrganizativa unidadOrganizativaId;


	private Date createdAt;
	
	private Date updatedAt;


}
