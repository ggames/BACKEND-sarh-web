package com.gestion.cargos.security.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
   Clase para la base de datos

        */
@Entity
@Table(name = "usuario", schema = "cargos")
@Data
public class Usuario {
    // Id tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Decorador para indicar que el campo no puede ser nulo
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;

    // Relacion many to many
    // Un usuario puede tener muchos roles y un rol puede pertenecer a varios usuarios
    // Tabla intermedia que tiene dos campos que va a tener idUsuario y Id rol

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)

    // Join Columns hace referencia  a la columna que hace referencia hacia esta
    // Es decir la tabla usuario_rol va a tener un campo que se llama id_usuario
    // InverseColumns = el inverso, hace referencia a rol
    @JoinTable(schema = "cargos", name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

}
