package com.gestion.cargos.repositorio;

import com.gestion.cargos.modelo.UnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.cargos.modelo.SubunidadOrganizativa;

import java.util.List;

@Repository
public interface SubunidadOrganizativaRepositorio extends JpaRepository<SubunidadOrganizativa, Long> {

    List<SubunidadOrganizativa>findByUnidadOrganizativaId(UnidadOrganizativa unidad);

    public boolean existsByCodigoGuarani(String codigoguarani);
	
}
