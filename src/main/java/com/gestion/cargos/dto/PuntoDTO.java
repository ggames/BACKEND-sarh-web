package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.PuntoOrigen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuntoDTO {

	private Long id;

	private String codigoCargo;
	
	private String nombreCargo;
	
	private String dedicacionCargo;
	
	private int cantidad_puntos;

	private List<PuntoOrigenDTO> origenes;

}
