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

	private TipoCargoDTO tipo_cargo;
	
	private int puntos_disponibles;

	private List<PuntoOrigenDTO> origenes;

}
