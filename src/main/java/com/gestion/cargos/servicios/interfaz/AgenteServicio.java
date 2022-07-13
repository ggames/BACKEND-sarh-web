package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.AgenteDto;
import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.modelo.Agente;

@Service
public interface AgenteServicio{
   /*
    *   firma de funciones que solo se encuentran en la interfaz
    * */
	
    List<AgenteDto> findAll();

    @Query("SELECT a FROM agente a WHERE a.nombre= ?1")
    AgenteDto findByNombre(String nombre);
    
    AgenteDto findByAgenteId(int id);
    
    public void save(AgenteRequest agente);
	
    public void update(AgenteRequest request, int agenteId);
    
    public void deleteAgente(int id);
	
	public Agente obtenerAgente(int id);
	
	public boolean existeAgente(int id);
	
}
