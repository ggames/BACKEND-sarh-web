package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.PuntoDto;
import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import com.gestion.cargos.servicios.interfaz.PuntoServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class PuntoServicioImpl implements PuntoServicio {

	@Autowired
	private PuntoRepositorio puntoRepositorio;

	@Override
	public List<PuntoDto> findAll() {
		Iterable<Punto> puntos = this.puntoRepositorio.findAll();
		List<PuntoDto> puntosDto = new ArrayList<>();

		for (Punto punto : puntos) {
			PuntoDto dto = MHelpers.modelMapper().map(punto, PuntoDto.class);
			puntosDto.add(dto);
		}

		return puntosDto;
	}

	@Override
	public PuntoDto findByPuntoId(Long id) {
		Optional<Punto> punto = this.puntoRepositorio.findById(id);
		if (!punto.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(punto, PuntoDto.class);

	}

	@Override
	public void save(PuntoRequest request) {
		Punto punto = MHelpers.modelMapper().map(request, Punto.class);

		this.puntoRepositorio.save(punto);
	}

	@Override
	public void update(Long puntoId, PuntoRequest request) {

		Optional<Punto> punto = this.puntoRepositorio.findById(puntoId);

		Punto uPunto = punto.get();

		uPunto.setCodigoCargo(request.getCodigoCargo());
		uPunto.setNombreCargo(request.getNombreCargo());
		uPunto.setDedicacionCargo(request.getDedicacionCargo());
		uPunto.setPuntos(request.getPuntos());

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
