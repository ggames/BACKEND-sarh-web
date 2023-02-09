package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cargos", schema = "cargos")
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private Long idCargo;
    @ManyToOne
    @JoinColumn(name = "unidad_organizacional_id")
    @JsonIgnoreProperties("cargos")
    private UnidadOrganizativa unidadOrganizativaId;

    @ManyToOne
    @JoinColumn(name = "punto_id")
    @JsonIgnoreProperties("cargos")
    private Punto puntoId;

    @ManyToOne
    @JoinColumn(name = "estado_cargo_id")
    @JsonIgnoreProperties("cargos")
    private EstadoCargo estadoCargo;

    @ManyToOne
    @JoinColumn(name = "caracter_id")
    @JsonIgnoreProperties("cargos")
    private CargoCaracter caracter;
    @ManyToOne
    @JoinColumn(name = "transf_creacion_id")
    private Transformacion transfCreacionId;

    @ManyToOne
    @JoinColumn(name = "transf_supresion_id")
    private Transformacion transfSupresionId;

    @JsonIgnoreProperties("cargoId")
    @OneToMany(mappedBy = "cargoId", cascade = CascadeType.ALL)
    private List<Planta> plantas = new ArrayList<>();

    private Date createdAt;

    private Date updatedAt;


    public Cargo(Long cargoId, UnidadOrganizativa unidadOrganizativaId, Punto puntoId, EstadoCargo estadoCargo, CargoCaracter caracter, Transformacion transfCreacionId, Transformacion transfSupresionId) {
        this.idCargo = cargoId;
        this.unidadOrganizativaId = unidadOrganizativaId;
        this.puntoId = puntoId;
        this.estadoCargo = estadoCargo;
        this.caracter = caracter;
        this.transfCreacionId = transfCreacionId;
        this.transfSupresionId = transfSupresionId;
    }

    public Cargo() {
    }

    public void addPlanta(Planta planta) {
        this.plantas.add(planta);
        planta.setCargoId(this);
    }
}
