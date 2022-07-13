package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.TransformacionDto;
import com.gestion.cargos.dto.TransformacionRequest;

@Service
public interface TransformacionServicio {
    	
	void save(TransformacionRequest request);
	
	void update(TransformacionRequest request, long id);
	
	boolean existeTransformacion(long id);
	
	List<TransformacionDto> findAll();
	
	TransformacionDto findByTransformacionId(long id);
	
    TransformacionDto findByNumeroResolucion(String nroresol);
}
