package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.modelo.Punto;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoRequest;
import org.springframework.util.MultiValueMap;

@Service
public interface PuntoServicio {

	List<Punto> findAllPuntos();
	List<PuntoDTO> findAll();

	List<PuntoDTO>findPuntoByTransitorioAndPuntosDisponibles(boolean transitorio, Long[] estadosCargos);
	
	PuntoDTO findByPuntoId(Long id);
	
	public void save(PuntoRequest request);

	public void update(Long puntoId, PuntoRequest request);
	
	public void delete(Long id);
	
	public boolean existPunto(Long id);

   public boolean existsByCodPunto(Long codpunto);
}
