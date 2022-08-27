package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoRequest;

@Service
public interface PuntoServicio {
  
	List<PuntoDTO> findAll();
	
	PuntoDTO findByPuntoId(Long id);
	
	public void save(PuntoRequest request);

	public void update(Long puntoId, PuntoRequest request);
	
	public void delete(Long id);
	
	public boolean existPunto(Long id);


}
