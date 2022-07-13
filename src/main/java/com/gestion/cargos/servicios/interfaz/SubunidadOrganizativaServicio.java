package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.SubunidadOrganizativaDto;
import com.gestion.cargos.dto.SubunidadOrganizativaRequest;

@Service
public interface SubunidadOrganizativaServicio {

	List<SubunidadOrganizativaDto>findAll();
	
	SubunidadOrganizativaDto findBySuborganizativa(Long id);
	
	void save(SubunidadOrganizativaRequest request);
	
	void update(SubunidadOrganizativaRequest request, Long id);
	
	void delete(Long id);
	
	SubunidadOrganizativaDto findBySubunidadOrganizativaId(Long id);
	
	boolean existeSubunidadOrganizativaId(Long id);
	
}
