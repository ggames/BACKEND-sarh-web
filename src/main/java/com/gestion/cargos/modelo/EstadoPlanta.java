package com.gestion.cargos.modelo;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EstadoPlanta", schema = "cargos") 
@Data
public class EstadoPlanta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreEstado;
	private Date createdAt;
	private Date updatedAt;

	
}
