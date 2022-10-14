package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_cargos", schema = "cargos")
@Data
public class TipoCargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo;

    private Double basico;

    private int cantidad_puntos;

    @JsonIgnoreProperties("tipo_cargo")
    @OneToMany(mappedBy = "tipo_cargo", cascade = CascadeType.ALL)
    private List<Punto> puntos;


}
