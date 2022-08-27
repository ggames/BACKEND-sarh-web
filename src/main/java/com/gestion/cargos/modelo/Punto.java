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
	@Column(name = "codigo_cargo")
	private String codigoCargo;
	@Column(name = "nombre_cargo")
	private String nombreCargo;
	@Column(name = "dedicacion_cargo")
	private String dedicacionCargo;
    
	private int cantidad_puntos;

	@JsonIgnoreProperties("puntoId")
    @OneToMany(mappedBy = "puntoId" , cascade = CascadeType.ALL)
	private List<PuntoOrigen> origenes;

	private Date createdAt;
    
	private Date updatedAt;

	public Punto(String codigoCargo, String nombreCargo, String dedicacionCargo, int cantidad_puntos) {
		this.codigoCargo = codigoCargo;
		this.nombreCargo = nombreCargo;
		this.dedicacionCargo = dedicacionCargo;
		this.cantidad_puntos = cantidad_puntos;
	}

	public Punto() {
	}
}
