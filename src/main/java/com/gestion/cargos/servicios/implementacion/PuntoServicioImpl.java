package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gestion.cargos.modelo.PuntoOrigen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import com.gestion.cargos.servicios.interfaz.PuntoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PuntoServicioImpl implements PuntoServicio {

	@Autowired
	private PuntoRepositorio puntoRepositorio;

	@Autowired
	private PuntosManager puntosManager;

	@Override
	public List<PuntoDTO> findAll() {
		Iterable<Punto> puntos = this.puntoRepositorio.findAll();
		List<PuntoDTO> puntosDto = new ArrayList<>();

		for (Punto punto : puntos) {
			PuntoDTO dto = MHelpers.modelMapper().map(punto, PuntoDTO.class);
			puntosDto.add(dto);
		}

		return puntosDto;
	}

	@Override
	public PuntoDTO findByPuntoId(Long id) {
		Optional<Punto> punto = this.puntoRepositorio.findById(id);
		if (!punto.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(punto, PuntoDTO.class);

	}

	@Override
	@Transactional
	public void save(PuntoRequest request) {
		//Punto punto = MHelpers.modelMapper().map(request, Punto.class);
        List<PuntoOrigen> items = request.getOrigenes().stream().map(
				puntoOrigenRequest -> new PuntoOrigen(puntoOrigenRequest.getPuntoOrigenId(), puntoOrigenRequest.getCantOcupados())
		).collect(Collectors.toList());

		Punto p =  new Punto(request.getTipo_cargo(), request.getPuntos_disponibles());
		      p.setOrigenes(items);

		for (PuntoOrigen item:items
			 ) {
			item.setPuntoId(p);
		}

		this.puntoRepositorio.save(p);
	}

	@Override
	@Transactional
	public void update(Long puntoId, PuntoRequest request) {

		Optional<Punto> punto = this.puntoRepositorio.findById(puntoId);

		Punto uPunto = punto.get();

		uPunto.setTipo_cargo (request.getTipo_cargo());
		uPunto.setPuntos_disponibles(request.getPuntos_disponibles());


		this.puntoRepositorio.save(uPunto);
	}

	@Override
	public void delete(Long id) {

		this.puntoRepositorio.deleteById(id);

	}

	@Override
	public boolean existPunto(Long id) {

		return this.puntoRepositorio.existsById(id);
	}

}
