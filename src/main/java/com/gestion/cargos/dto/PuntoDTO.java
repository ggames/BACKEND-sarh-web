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

	private Long codPunto;

	private TipoCargoDTO tipo_cargo;
	
	private int puntos_disponibles;

	private int puntos_faltantes;
	private List<PuntoOrigenDTO> origenes;

	private boolean transitorio;

}
