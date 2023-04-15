package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.cargos.enums.ECargoNombre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "estado_cargo", schema = "cargos")
@Data
@AllArgsConstructor
public class EstadoCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ECargoNombre estado_cargo;

    private String nombre;

    @OneToMany(mappedBy = "estadoCargo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estadoCargo")
    private List<Cargo> cargos;


    public EstadoCargo(){}

/*    public EstadoCargo(@NotNull ECargoNombre estado, @NotNull String nombre){
         this.estado_cargo = estado;
         this.nombre = nombre;
    }*/
}
