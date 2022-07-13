package com.gestion.cargos.servicios.interfaz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.cargos.modelo.TipoDocumento;

@Service
public interface TipoDocumentoServicio {
	
	public List<TipoDocumento>listadoTipoDocumento();
	

}
