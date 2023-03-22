package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.cargos.enums.cCaracterNombre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "cargo_caracter", schema = "cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoCaracter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private cCaracterNombre caracter;

    @NotNull
    private String nombre;

    @JsonIgnoreProperties(value = {"caracter"})
    @OneToMany(mappedBy ="caracter", cascade = CascadeType.ALL)
    private List<Cargo> cargos;


}
