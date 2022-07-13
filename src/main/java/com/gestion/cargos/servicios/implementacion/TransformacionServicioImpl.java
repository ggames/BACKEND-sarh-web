package com.gestion.cargos.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gestion.cargos.dto.TransformacionDto;
import com.gestion.cargos.dto.TransformacionRequest;
import com.gestion.cargos.modelo.Transformacion;
import com.gestion.cargos.repositorio.TransformacionRepositorio;
import com.gestion.cargos.servicios.interfaz.TransformacionServicio;
import com.gestion.cargos.utils.MHelpers;

@Component
public class TransformacionServicioImpl implements TransformacionServicio{

	@Autowired
	private TransformacionRepositorio transformacionRepositorio;
	
	@Override
	public List<TransformacionDto> findAll() {
		
		List<TransformacionDto> dto = new ArrayList<>();
		
		Iterable<Transformacion> transformaciones = transformacionRepositorio.findAll(); 
		
		for(Transformacion transformacion: transformaciones) {
	       // System.out.println(transformacion.getNumeroResolucion() + " " + transformacion.getResultadoTransformacion() );  
			TransformacionDto transfDto = MHelpers.modelMapper().map(transformacion, TransformacionDto.class );		
		   
			dto.add(transfDto);
		}
		return dto; 
	}
	

	@Override
	public void save(TransformacionRequest request) {
       Transformacion transformacionguardar = MHelpers.modelMapper().map(request, Transformacion.class);

       transformacionRepositorio.save(transformacionguardar);
	}

	@Override
	public void update(TransformacionRequest request, long id) {

        Optional<Transformacion> transformacion = this.transformacionRepositorio.findById(id);
        
        Transformacion uTransformacion = transformacion.get();
        
        uTransformacion.setNumeroResolucion(request.getNumeroResolucion());
        uTransformacion.setResultadoTransformacion(request.getResultadoTransformacion());

        this.transformacionRepositorio.save(uTransformacion);
	}

	@Override
	public boolean existeTransformacion(long id) {
		// TODO Auto-generated method stub
		return this.transformacionRepositorio.existsById(id);
	}

	@Override
	public TransformacionDto findByNumeroResolucion(String nroresol) {
		// TODO Auto-generated method stub
		Optional<Transformacion> transform = this.transformacionRepositorio.findByNumeroResolucion(nroresol);
	   if(!transform.isPresent()) {
		  return null;   
	   }
	 
	   return MHelpers.modelMapper().map(transform.get(), TransformacionDto.class);
	}


	@Override
	public TransformacionDto findByTransformacionId(long id) {
		Optional<Transformacion> transformacion = this.transformacionRepositorio.findById(id);
		
		if(!transformacion.isPresent()) {
			return null;	
		}
		// TODO Auto-generated method stub
		return MHelpers.modelMapper().map(transformacion, TransformacionDto.class);
	}

}
