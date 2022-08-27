package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.EstadoPlantaDTO;
import com.gestion.cargos.dto.EstadoPlantaRequest;

@Service
public interface EstadoPlantaServicio {

	void save(EstadoPlantaRequest request);
	
	void update(EstadoPlantaRequest request, Long id);
	
	boolean existEstadoPlanta(Long id);

	List<EstadoPlantaDTO> findAll();
	
	EstadoPlantaDTO findByEstadoPlantaId(Long id);
	
	
}
