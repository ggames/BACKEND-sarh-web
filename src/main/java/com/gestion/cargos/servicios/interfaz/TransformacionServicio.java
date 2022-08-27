package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.TransformacionDTO;
import com.gestion.cargos.dto.TransformacionRequest;

@Service
public interface TransformacionServicio {
    	
	void save(TransformacionRequest request);
	
	void update(TransformacionRequest request, long id);
	
	boolean existeTransformacion(long id);
	
	List<TransformacionDTO> findAll();
	
	TransformacionDTO findByTransformacionId(long id);
	
    TransformacionDTO findByNumeroResolucion(String nroresol);
}
