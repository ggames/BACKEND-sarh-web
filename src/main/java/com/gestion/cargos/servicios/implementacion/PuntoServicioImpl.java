package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gestion.cargos.dto.PlantaDTO;
import com.gestion.cargos.modelo.Planta;
import com.gestion.cargos.modelo.PuntoOrigen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.PuntoDTO;
import com.gestion.cargos.dto.PuntoRequest;
import com.gestion.cargos.modelo.Punto;
import com.gestion.cargos.repositorio.PuntoRepositorio;
import com.gestion.cargos.servicios.interfaz.PuntoServicio;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PuntoServicioImpl implements PuntoServicio {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PuntoRepositorio puntoRepositorio;

	@Autowired
	private PuntosManager puntosManager;


	@Override
	public List<Punto> findAllPuntos() {
		return this.puntoRepositorio.findAll();
	}

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
	public List<PuntoDTO> findPuntoByTransitorioAndPuntosDisponibles(boolean transitorio, Long[] estadosCargosID) {

		//Iterable<Punto> puntos = this.puntoRepositorio.findPuntoByTransitorioAndByPuntosDisponibles(transitorio);
	    Iterable<Punto> puntos = this.puntoRepositorio.
				findPuntoByTransitorioByEstadoCargoList(transitorio, estadosCargosID );
		List<PuntoDTO> puntosDto = new ArrayList<>();
		for (Punto punto: puntos){
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

	public Punto findById(Long id){
		return this.puntoRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(PuntoRequest request) {
		//Punto punto = MHelpers.modelMapper().map(request, Punto.class);
        List<PuntoOrigen> items = request.getOrigenes().stream().map(
				puntoOrigenRequest -> new PuntoOrigen(puntoOrigenRequest.getPuntoOrigenId(), puntoOrigenRequest.getCantOcupados())
		).collect(Collectors.toList());

		logger.info("CANTIDAD DE PUNTOS ORIGEN " + items.size());

		Punto p =  new Punto(request.getCodPunto(), request.getTipo_cargo(), request.getPuntos_disponibles(), request.getPuntos_faltantes(),request.isTransitorio());
		      p.setOrigenes(items);

		if(!items.isEmpty()) {
			for (PuntoOrigen item : items
			) {

				item.setPuntoId(p);
				updatePuntos(item.getPuntoOrigenId(), item.getCantOcupados());
			}
		}
		this.puntoRepositorio.save(p);
	}

    // Actualiza la cantidad de puntos disponibles cuando los puntos son ocupados para crear
	// Nuevos Puntos
	public void updatePuntos(Long puntoId, int cant_ocupado){

		Optional<Punto> punto = this.puntoRepositorio.findById(puntoId);

		Punto uPunto = punto.get();

		uPunto.setPuntos_disponibles(uPunto.getPuntos_disponibles() - cant_ocupado);

		this.puntoRepositorio.save(uPunto);
	}

	public void updatePuntosParitaria(Long puntoId, int nuevaCantidad ){
		Optional<Punto> punto = this.puntoRepositorio.findById(puntoId);

		Punto uPunto = punto.get();

		uPunto.setPuntos_disponibles(nuevaCantidad);

		this.puntoRepositorio.save(uPunto);
	}

	@Override
	@Transactional
	public void update(Long puntoId, PuntoRequest request) {

		Optional<Punto> punto = this.puntoRepositorio.findById(puntoId);

		Punto uPunto = punto.get();

	 	// uPunto.setTipo_cargo (request.getTipo_cargo());
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

	@Override
	public boolean existsByCodPunto(Long codpunto) {
		return this.puntoRepositorio.existsByCodPunto(codpunto);
	}

}
