package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "UnidadesOrganizativas", schema = "cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadOrganizativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int directorId;

    private int viceDirectorId;

    @JsonIgnoreProperties("unidadOrganizativaID")
    @OneToMany(mappedBy = "unidadOrganizativaID", cascade = CascadeType.ALL)
    private List<SubunidadOrganizativa> subunidades = new ArrayList<>();

    @JsonIgnoreProperties(value = "unidadOrganizativaId", allowSetters = true)
    @OneToMany(mappedBy = "unidadOrganizativaId", cascade = CascadeType.ALL)
    private List<Cargo>ucargos = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


}



