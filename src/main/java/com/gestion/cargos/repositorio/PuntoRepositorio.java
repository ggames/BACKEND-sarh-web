package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.Cargo;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.modelo.Punto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntoRepositorio extends JpaRepository<Punto, Long> {

    @Query("Select p from Punto p where p.transitorio = ?1 and p.puntos_disponibles > 0")
    List<Punto>findPuntoByTransitorioAndByPuntosDisponibles(boolean transitorio);

    //@Query(value = "SELECT p FROM Punto p WHERE p.transitorio = :transitorio and p.cargo NOT IN :listaCargo")
    //List<Punto>findPuntoByTransitorioByEstadoCargoList(@Param("transitorio") boolean transitorio,@Param("listaCargo") List<Cargo> listaCargo);

    @Query(value = "Select * From cargos.puntos p LEFT JOIN cargos.cargos c " +
            "ON p.id = c.punto_id where c.estado_cargo_id  IN :estadoCargoID OR c.estado_cargo_id IS NULL " +
            "and transitorio = :transitorio and p.puntos_disponibles > 0", nativeQuery = true)
    List<Punto>findPuntoByTransitorioByEstadoCargoList(@Param("transitorio") boolean transitorio,
                                                       @Param("estadoCargoID") Long[] listaCargo);
}
