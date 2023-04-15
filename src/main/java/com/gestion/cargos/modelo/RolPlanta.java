package com.gestion.cargos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RolPlanta", schema = "cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolPlanta {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String tipoRol;
    
    @ManyToOne
    @JoinColumn(name = "subunidad_organizativa_id")
	private SubunidadOrganizativa subunidadOrganizativaId;
    
    @ManyToOne
    @JoinColumn(name = "planta_id")
    private Planta plantaId;
    
    private Date createdAt;
    
    private Date updateAt;


    
}
