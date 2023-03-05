package com.gestion.cargos.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.gestion.cargos.enums.RolNombre;
import lombok.Data;

@Entity
@Table(name = "rol", schema = "cargos")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    @NotNull
    private String nombre;

    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre, @NotNull String nombre) {
        this.rolNombre = rolNombre;
        this.nombre = nombre;
    }


}
