package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.AgenteDTO;
import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.modelo.Agente;
import com.gestion.cargos.repositorio.AgenteRepositorio;
import com.gestion.cargos.servicios.interfaz.AgenteServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class AgenteServicioImpl implements AgenteServicio {

	@Autowired
	private AgenteRepositorio agenteRepositorio;

	@Override
	public List<AgenteDTO> findAll() {

		List<AgenteDTO> dto = new ArrayList<>();

		Iterable<Agente> agentes = this.agenteRepositorio.findAll();

		for (Agente agente : agentes) {

			AgenteDTO agenteDto = MHelpers.modelMapper().map(agente, AgenteDTO.class);

			dto.add(agenteDto);
		}


		return dto;
	}

	@Override
	public AgenteDTO findByNombre(String nombre) {

		Optional<Agente> agente = this.agenteRepositorio.findByNombre(nombre);

		if (!agente.isPresent()) {

			return null;
		}

		return MHelpers.modelMapper().map(agente.get(), AgenteDTO.class);
	}

	@Override
	public AgenteDTO findByAgenteId(Long id) {

		Optional<Agente> agentes = this.agenteRepositorio.findById(id);

		if (!agentes.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(agentes.get(), AgenteDTO.class);
	}

	@Override
	public void update(AgenteRequest request, Long agenteId) {

		Optional<Agente> agente = this.agenteRepositorio.findById(agenteId);

		Agente uAgente = agente.get();

		uAgente.setNombre(request.getNombre());
		uAgente.setApellido(request.getApellido());
		uAgente.setDocumento(request.getDocumento());
		uAgente.setTipoDocId(request.getTipoDocId());
		uAgente.setDocumento(request.getDocumento());
		uAgente.setLegajo(request.getLegajo());
		uAgente.setFechaNac(request.getFechaNac());
		uAgente.setEmail(request.getEmail());
		uAgente.setDomicilio(request.getDomicilio());

		this.agenteRepositorio.save(uAgente);
	}

	@Override
	public void save(AgenteRequest agente) {

		Agente agenteGuardar = MHelpers.modelMapper().map(agente, Agente.class);

		/// System.err.println("ID AFECTADO " + agenteGuardar.getId());

		agenteRepositorio.save(agenteGuardar);
	}

	@Override
	public Agente obtenerAgente(Long id) {
		// TODO Auto-generated method stub
		return agenteRepositorio.findById(id).orElse(null);
	}

	@Override
	public boolean existeAgente(Long id) {
		// TODO Auto-generated method stub
		return agenteRepositorio.existsById(id);
	}

	public boolean existsByNombre(String nombre) {
		return agenteRepositorio.existsByNombre(nombre);
	}

	@Override
	public void deleteAgente(Long id) {
		// TODO Auto-generated method stub
		agenteRepositorio.deleteById(id);
	}

	private AgenteDTO convertToAgenteDto(final Agente agente) {

		return MHelpers.modelMapper().map(agente, AgenteDTO.class);
	}

}