package com.gestion.cargos.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "UnidadesOrganizativas", schema = "cargos")
@Data
public class UnidadOrganizativa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int directorId;

    private int viceDirectorId;

    @OneToMany(mappedBy = "unidadOrganizativaId", cascade = CascadeType.ALL)
    private List<SubunidadOrganizativa> subunidades = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public UnidadOrganizativa(String nombre, int directorId, int viceDirectorId) {
        this.nombre = nombre;
        this.directorId = directorId;
        this.viceDirectorId = viceDirectorId;
    }

    public UnidadOrganizativa() {
    }
}



