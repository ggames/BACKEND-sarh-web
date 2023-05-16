package com.gestion.cargos.specifications;

import com.gestion.cargos.dto.BusquedaDTO;
import com.gestion.cargos.modelo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class PlantaSpecification {

    public static Specification<Planta> hasLastNameLike(String apellido){
        return ((root, query, criteriaBuilder) -> {
            Join<Agente, Planta> plantaAgente = root.join("agenteId");
            return criteriaBuilder.like(criteriaBuilder.upper(plantaAgente.get("apellido")), "%" + apellido.toUpperCase() + "%");

        });
    }
    public static Specification<Planta> hasTypeCargo(String tipocargo){
        return ((root, query, criteriaBuilder) -> {
            Join<Cargo, Planta> plantaCargo = root.join("cargoId");
            Join<Punto, Cargo> cargoPunto = plantaCargo.join("puntoId");
            Join<TipoCargo,Punto> tipoCargoPuntoJoin = cargoPunto.join("tipo_cargo", JoinType.LEFT);
            return criteriaBuilder.like(tipoCargoPuntoJoin.get("cargo"),"%" + tipocargo + "%");
        });
    }

    public static Specification<Planta> hasSubject(String materia){
        return ((root, query, criteriaBuilder) -> {
            Join<SubunidadOrganizativa, Planta> plantaMateria = root.join("subunidadOrganizativaId");
            return criteriaBuilder.equal(plantaMateria.get("nombre"), materia);
        });
    }

    public static Specification<Planta> hasDepartament(String departamento){
        return ((root, query, criteriaBuilder) -> {
            Join<Cargo, Planta> plantaCargo = root.join("cargoId");
            Join<UnidadOrganizativa, Cargo> cargoDepartamento = plantaCargo.join("unidadOrganizativaId", JoinType.LEFT);
            return criteriaBuilder.equal(cargoDepartamento.get("nombre"), departamento);
        });
    }


    public static Specification<Planta> createSpecification(BusquedaDTO criteria){
       Specification<Planta> specification = Specification.where(null);

       if(criteria != null){
           if(!StringUtils.isBlank(criteria.getDocente())){
               specification = specification.and(hasLastNameLike(criteria.getDocente()));
           }
           if(!StringUtils.isBlank(criteria.getMateria())){
               specification = specification.and(hasSubject(criteria.getMateria()));
           }
           if(!StringUtils.isBlank(criteria.getDepartamento())){
               specification = specification.and(hasDepartament(criteria.getDepartamento()));
           }
           if(!StringUtils.isBlank(criteria.getTipocargo())){
               specification = specification.and(hasTypeCargo(criteria.getTipocargo()));
           }
       }
        return specification;
    }
}
