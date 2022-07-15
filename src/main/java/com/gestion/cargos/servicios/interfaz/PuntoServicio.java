package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoDto;
import com.gestion.cargos.dto.PuntoRequest;

@Service
public interface PuntoServicio {
  
	List<PuntoDto> findAll();
	
	PuntoDto findByPuntoId(Long id);
	
	public void save(PuntoRequest request);

	public void update(PuntoRequest request, Long puntoId);
	
	public void delete(Long id);
	
	public boolean existPunto(Long id);
	
}
