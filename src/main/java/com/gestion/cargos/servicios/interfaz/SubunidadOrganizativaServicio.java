package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.SubunidadOrganizativaDTO;
import com.gestion.cargos.dto.SubunidadOrganizativaRequest;

@Service
public interface SubunidadOrganizativaServicio {

	List<SubunidadOrganizativaDTO>findAll();
	
	SubunidadOrganizativaDTO findBySuborganizativa(Long id);
	
	void save(SubunidadOrganizativaRequest request);
	
	void update(SubunidadOrganizativaRequest request, Long id);
	
	void delete(Long id);
	
	SubunidadOrganizativaDTO findBySubunidadOrganizativaId(Long id);
	
	boolean existeSubunidadOrganizativaId(Long id);
	
}
