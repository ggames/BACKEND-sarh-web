package com.gestion.cargos.dto;

import com.gestion.cargos.modelo.EstadoPlanta;
import com.gestion.cargos.modelo.Planta;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class HistoriaPlantaDto {

    private Long id;

    private Planta plantaId;

    private EstadoPlanta estadoPlantaId;

    private String resolucionInicio;

    private Date fechaInicio;

    private String resolucionFin;

    private Date fechaFin;

}
