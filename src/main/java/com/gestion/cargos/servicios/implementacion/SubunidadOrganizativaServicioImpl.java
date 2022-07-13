package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.SubunidadOrganizativaDto;
import com.gestion.cargos.dto.SubunidadOrganizativaRequest;
import com.gestion.cargos.dto.TransformacionDto;
import com.gestion.cargos.modelo.SubunidadOrganizativa;
import com.gestion.cargos.modelo.Transformacion;
import com.gestion.cargos.repositorio.SubunidadOrganizativaRepositorio;
import com.gestion.cargos.servicios.interfaz.SubunidadOrganizativaServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class SubunidadOrganizativaServicioImpl implements SubunidadOrganizativaServicio{

	@Autowired
	private SubunidadOrganizativaRepositorio subunidadOrganizativaRepositorio;
	
	@Override
	public List<SubunidadOrganizativaDto> findAll() {
		
		Iterable<SubunidadOrganizativa> subUnidadesOrg =  this.subunidadOrganizativaRepositorio.findAll();
		
		List<SubunidadOrganizativaDto>subUnidadesDto = new ArrayList<>();
		
		for (SubunidadOrganizativa Subunidades: subUnidadesOrg) {
		
			SubunidadOrganizativaDto subDTO = MHelpers.modelMapper()
					    .map(Subunidades, SubunidadOrganizativaDto.class);
		
		   subUnidadesDto.add(subDTO);
		}
		
		return subUnidadesDto;
	}

	@Override
	public SubunidadOrganizativaDto findBySuborganizativa(Long id) {
		
		SubunidadOrganizativaDto dto;
		
		Optional<SubunidadOrganizativa> subunidad = subunidadOrganizativaRepositorio.findById(id);
		
		dto = MHelpers.modelMapper().map(subunidad, SubunidadOrganizativaDto.class);
		return dto;
	}

	@Override
	public void save(SubunidadOrganizativaRequest request) {
		
		SubunidadOrganizativa subunidad = MHelpers.modelMapper().map(request, SubunidadOrganizativa.class);
		
		this.subunidadOrganizativaRepositorio.save(subunidad);
	}

	@Override
	public void update(SubunidadOrganizativaRequest request, Long id) {

		Optional<SubunidadOrganizativa> subunidad = this.subunidadOrganizativaRepositorio.findById(id);
		
		SubunidadOrganizativa uSubunidad = subunidad.get();
		
		uSubunidad.setCodigoGuarani(request.getCodigoGuarani());
		uSubunidad.setNombre(request.getNombre());
		uSubunidad.setUnidadOrganizativaId(request.getUnidadOrganizativaId());
		
		this.subunidadOrganizativaRepositorio.save(uSubunidad);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean existeSubunidadOrganizativaId(Long id) {
		// TODO Auto-generated method stub
		return this.subunidadOrganizativaRepositorio.existsById(id);
	}

	@Override
	public SubunidadOrganizativaDto findBySubunidadOrganizativaId(Long id) {
		Optional<SubunidadOrganizativa> subunidad = this.subunidadOrganizativaRepositorio.findById(id);
		
		if(!subunidad.isPresent()) {
			return null;	
		}
		// TODO Auto-generated method stub
		return MHelpers.modelMapper().map(subunidad , SubunidadOrganizativaDto.class);
	}

}
