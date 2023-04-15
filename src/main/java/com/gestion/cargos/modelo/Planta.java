package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.cargos.dto.PuntoDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@SqlResultSetMapping(name = "DetailMapping",
           classes = @ConstructorResult(
				   targetClass = PuntoDetailDTO.class,
				   columns = {
						   @ColumnResult(name = "id", type = Long.class),
						   @ColumnResult(name = "tipoCargo"),
						   @ColumnResult(name="cargoID", type = Long.class),
						   @ColumnResult(name = "puntoDisponible", type = Long.class),
						   @ColumnResult(name="nombreApellido")
				   }
		   ))

@Entity
@Table(name = "Planta", schema = "cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cargo_id")
	@JsonIgnoreProperties("plantas")
	private Cargo cargoId;

	@ManyToOne
	@JoinColumn(name = "agente_id")
	private Agente agenteId;

	@ManyToOne
	@JoinColumn(name = "subunidad_organizativa_id")
	@JsonIgnoreProperties(allowSetters = true)
	private SubunidadOrganizativa subunidadOrganizativaId;

	private Date fechaMovimiento;

	private String motivoMovimiento;

	private String resolucionInicio;

	private Date fechaInicio;

	private String resolucionFin;

	private Date fechaFin;

	private Date lic_Desde;

	private Date lic_Hasta;

	private Date fechaCese;

	private Date createdAt;

	private Date updateAt;

	/*public Planta(Cargo cargoId, Agente agenteId, Date fechaMovimiento, String motivoMovimiento) {
		this.cargoId = cargoId;
		this.agenteId = agenteId;
		this.fechaMovimiento = fechaMovimiento;
		this.motivoMovimiento = motivoMovimiento;
	}

	public Planta() {
	}*/

}
