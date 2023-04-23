package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

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

	private Long codPunto;
	@ManyToOne
	@JoinColumn(name = "tipo_cargo_id")
	@JsonIgnoreProperties("puntos")
	private TipoCargo tipo_cargo;

	@JsonIgnoreProperties(value = "puntoId", allowSetters = true)
	@OneToMany(mappedBy = "puntoId", cascade = CascadeType.ALL)
	private List<Cargo> cargos;
	private int puntos_disponibles;
	@Column(name = "puntos_faltantes", nullable = true)
	private int puntos_faltantes;

	@JsonIgnoreProperties(value = "puntoId", allowSetters = true)
    @OneToMany(mappedBy = "puntoId" , cascade = CascadeType.ALL)
	private List<PuntoOrigen> origenes;


	private boolean transitorio;
    @Column(columnDefinition = "boolean default false"
	)
	private boolean deRectorado;

	private Date createdAt;
    
	private Date updatedAt;

	public Punto(Long codPunto,TipoCargo tipo_cargo , int cantidad_puntos, int faltante, boolean transitorio, boolean deRectorado) {
		this.codPunto = codPunto;
		this.tipo_cargo = tipo_cargo;
		this.puntos_disponibles = cantidad_puntos;
		this.puntos_faltantes = faltante;
		this.transitorio = transitorio;
		this.deRectorado = deRectorado;
	}

	public Punto() {
	}
}
