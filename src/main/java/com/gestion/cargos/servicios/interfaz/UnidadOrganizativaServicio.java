package com.gestion.cargos.servicios.interfaz;

import java.util.List;


import com.gestion.cargos.dto.UnidadOrganizativaDto;
import com.gestion.cargos.dto.UnidadOrganizativaRequest;
import com.gestion.cargos.modelo.UnidadOrganizativa;

public interface UnidadOrganizativaServicio  {

	List<UnidadOrganizativaDto> findAll();
	
	public void saveUnidadOrganizativa(UnidadOrganizativaRequest request);

	public void updateUnidadOrganizativa(Long id, UnidadOrganizativaRequest request);

    public boolean existeUnidadOrganizativa(Long id);
  
    public UnidadOrganizativa obtenerUnidadOrganizativa(Long id);	

}
