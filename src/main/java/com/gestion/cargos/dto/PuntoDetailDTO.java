package com.gestion.cargos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public interface PuntoDetailDTO {

    Long getId();

    String getNombre();

    String getApellido();

    String getCargo();

    Integer getCodCargo();

    Integer getDisponible();

    String getEstado();

}
