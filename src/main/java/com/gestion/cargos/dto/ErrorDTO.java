package com.gestion.cargos.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {

	private String code;

	private String message;

}
