package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.gestion.cargos.dto.AgenteDTO;
import com.gestion.cargos.dto.AgenteRequest;
import com.gestion.cargos.modelo.Agente;

@Service
public interface AgenteServicio{
   /*
    *   firma de funciones que solo se encuentran en la interfaz
    * */
	
    List<AgenteDTO> findAll();

    @Query("SELECT a FROM agente a WHERE a.nombre= ?1")
    AgenteDTO findByNombre(String nombre);

    @Query("SELECT a FROM agente a WHERE a.documento= ?1")
    AgenteDTO findByDocumento(Integer documento);
    AgenteDTO findByAgenteId(Long id);
    
    public void save(AgenteRequest agente);
	
    public void update(AgenteRequest request, Long agenteId);
    
    public void deleteAgente(Long id);
	
	public Agente obtenerAgente(Long id);
	
	public boolean existeAgente(Long id);
	
}
