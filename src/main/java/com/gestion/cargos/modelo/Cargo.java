package com.gestion.cargos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cargos", schema = "cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private Long idCargo;
    @ManyToOne
    @JsonIgnoreProperties(value = {"ucargos"})
    @JoinColumn(name = "unidad_organizativa_id")
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
    @JsonIgnoreProperties(value = {"cargos"})
    @JoinColumn(name = "caracter_id")
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



    public void addPlanta(Planta planta) {
        this.plantas.add(planta);
        planta.setCargoId(this);
    }
}
