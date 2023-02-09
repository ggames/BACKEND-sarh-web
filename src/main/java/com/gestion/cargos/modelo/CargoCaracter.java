package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.cargos.enums.cCaracterNombre;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "cargo_caracter", schema = "cargos")
@Data
public class CargoCaracter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private cCaracterNombre caracter;

    @NotNull
    private String nombre;

    @OneToMany(mappedBy ="caracter", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("caracter")
    private List<Cargo> cargos;

    public CargoCaracter(){}

    public CargoCaracter(@NotNull cCaracterNombre caracter, @NotNull String nombre){
        this.caracter = caracter;
        this.nombre = nombre;
    }
}
