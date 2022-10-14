package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Puntos", schema = "cargos")
@Data
public class Punto {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "tipo_cargo_id")
	@JsonIgnoreProperties("puntos")
	private TipoCargo tipo_cargo;
    
	private int puntos_disponibles;

	@JsonIgnoreProperties("puntoId")
    @OneToMany(mappedBy = "puntoId" , cascade = CascadeType.ALL)
	private List<PuntoOrigen> origenes;

	private Date createdAt;
    
	private Date updatedAt;

	public Punto(TipoCargo tipo_cargo , int cantidad_puntos) {
		this.tipo_cargo = tipo_cargo;
		this.puntos_disponibles = cantidad_puntos;
	}

	public Punto() {
	}
}
