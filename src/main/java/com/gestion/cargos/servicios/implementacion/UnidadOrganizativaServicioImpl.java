package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.UnidadOrganizativaDto;
import com.gestion.cargos.dto.UnidadOrganizativaRequest;
import com.gestion.cargos.modelo.UnidadOrganizativa;
import com.gestion.cargos.repositorio.UnidadOrganizativaRepositorio;
import com.gestion.cargos.servicios.interfaz.UnidadOrganizativaServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class UnidadOrganizativaServicioImpl implements UnidadOrganizativaServicio {

	@Autowired
	private UnidadOrganizativaRepositorio unidadOrganizativa;

	@Override
	public List<UnidadOrganizativaDto> findAll() {
         
		List<UnidadOrganizativaDto> dto = new ArrayList<>();
		
		Iterable<UnidadOrganizativa> unidades = this.unidadOrganizativa.findAll(); 
		
		for(UnidadOrganizativa unidadOrg: unidades) {
		
			UnidadOrganizativaDto unidadDto = MHelpers.modelMapper().map(unidadOrg, UnidadOrganizativaDto.class);
		    
			dto.add(unidadDto);
		}
		// TODO Auto-generated method stMensajeub
		return dto;
	}

	@Override
	public void saveUnidadOrganizativa(UnidadOrganizativaRequest request) {
		
		UnidadOrganizativa unidadGuardar = MHelpers.modelMapper().map(request, UnidadOrganizativa.class);
		
		this.unidadOrganizativa.save(unidadGuardar);
	}

	@Override
	public void updateUnidadOrganizativa(Long id, UnidadOrganizativaRequest request) {
       
		Optional<UnidadOrganizativa> unidadO = this.unidadOrganizativa.findById(id);
		
		UnidadOrganizativa updateUnidadOrg = unidadO.get(); 

      //  System.out.println("DATOS DE NOMBRE ORGANIZACION: " + request.getNombre()); 
		
		updateUnidadOrg.setNombre(request.getNombre());
		updateUnidadOrg.setDirectorId(request.getDirectorId());
		updateUnidadOrg.setViceDirectorId(request.getViceDirectorId());
		
		this.unidadOrganizativa.save(updateUnidadOrg);
	}

	@Override
	public boolean existeUnidadOrganizativa(Long id) {
		// TODO Auto-generated method stub
		return this.unidadOrganizativa.existsById(id);
	}

	@Override
	public UnidadOrganizativa obtenerUnidadOrganizativa(Long id) {
		// TODO Auto-generated method stub
		return this.unidadOrganizativa.findById(id).orElse(null);
	}

}
