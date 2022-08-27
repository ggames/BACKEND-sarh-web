package com.gestion.cargos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "DetallesPlanta", schema = "cargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePlanta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "planta_id")
	private Planta plantaId;
	
	@ManyToOne
	@JoinColumn(name = "estado_planta_id")
	private EstadoPlanta estadoPlantaId;
	
	private String resolucionInicio;

	private Date fechaInicio;
	
	private String resolucionFin;
	
	private Date fechaFin;


}
