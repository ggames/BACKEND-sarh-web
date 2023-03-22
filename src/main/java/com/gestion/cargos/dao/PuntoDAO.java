package com.gestion.cargos.dao;

import com.gestion.cargos.dto.PuntoDetailDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PuntoDAO {

    @PersistenceContext
    private EntityManager em;

    public List<PuntoDetailDTO>findPuntosDetalle(){
        String sql = "SELECT pp.id, CONCAT(ag.nombre, ' - ' ,ag.apellido) As nombre, tc.cargo , pp.puntos_disponibles \n" +
                " pp.puntos_faltantes As faltantes FROM cargos.planta pl LEFT JOIN  cargos.cargos ca ON pl.cargo_id = ca.id  " +
                " LEFT JOIN cargos.agente ag ON ag.id = pl.agente_id " +
                " RIGHT JOIN cargos.puntos pp ON pp.id = ca.punto_id LEFT JOIN cargos.tipo_cargos tc \n" +
                " ON tc.id = pp.tipo_cargo_id";

        TypedQuery<PuntoDetailDTO> consulta = em.createQuery(sql, PuntoDetailDTO.class);
        return consulta.getResultList();
    }

}
