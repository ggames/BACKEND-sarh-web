package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrigenPuntos", schema = "cargos")
@Data
public class PuntoOrigen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Codigo del punto de Origen
    private Long puntoOrigenId;
    // Codigos de los puntos que le dan origen al punto actual
    @ManyToOne(optional = true)
    @JoinColumn(name = "punto_id")
    @JsonIgnoreProperties("origenes")
    private Punto puntoId;

    private int cantOcupados;

    private Date createdAt;

    private Date updatedAt;
    public PuntoOrigen(Long puntoOrigenId, int cantOcupados) {
        this.puntoOrigenId = puntoOrigenId;

        this.cantOcupados = cantOcupados;
    }

    public PuntoOrigen() {
    }
}
