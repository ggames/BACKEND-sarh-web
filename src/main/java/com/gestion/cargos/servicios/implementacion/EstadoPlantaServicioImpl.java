package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.EstadoPlantaDto;
import com.gestion.cargos.dto.EstadoPlantaRequest;
import com.gestion.cargos.modelo.EstadoPlanta;
import com.gestion.cargos.repositorio.EstadoPlantaRepositorio;
import com.gestion.cargos.servicios.interfaz.EstadoPlantaServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class EstadoPlantaServicioImpl implements EstadoPlantaServicio {
 
	@Autowired
	private EstadoPlantaRepositorio estadoPlantaRepositorio;

	@Override
	public List<EstadoPlantaDto> findAll() {

		Iterable<EstadoPlanta> estados = this.estadoPlantaRepositorio.findAll();

		List<EstadoPlantaDto>dto = new ArrayList<>();
		
		for (EstadoPlanta estado: estados) {
			EstadoPlantaDto estadoPlantaDto = MHelpers.modelMapper().map(estado, EstadoPlantaDto.class);
		    dto.add(estadoPlantaDto);
		}
		// TODO Auto-generated method stub
		return dto;
	}

	@Override
	public void save(EstadoPlantaRequest request) {
		
		EstadoPlanta estadoPlanta = MHelpers.modelMapper().map(request, EstadoPlanta.class);
		
		this.estadoPlantaRepositorio.save(estadoPlanta);
	}

	@Override
	public void update(EstadoPlantaRequest request, Long id) {
		
		Optional<EstadoPlanta> estado = this.estadoPlantaRepositorio.findById(id);
		
		EstadoPlanta uEstado = estado.get();
		
		uEstado.setNombreEstado(request.getNombre());

		this.estadoPlantaRepositorio.save(uEstado);
	}

	@Override
	public boolean existeEstadoPlanta(Long id) {
         
		return this.estadoPlantaRepositorio.existsById(id);
	}

	@Override
	public EstadoPlantaDto findByEstadoPlantaId(Long id) {

		Optional<EstadoPlanta> estado = this.estadoPlantaRepositorio.findById(id);
		
		if(!estado.isPresent()) {
			
			return null;
		}
		
		return MHelpers.modelMapper().map(estado, EstadoPlantaDto.class);
	}

}
