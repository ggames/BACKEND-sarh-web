package com.gestion.cargos.servicios.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.cargos.modelo.TipoDocumento;
import com.gestion.cargos.repositorio.TipoDocumentoRepositorio;
import com.gestion.cargos.servicios.interfaz.TipoDocumentoServicio;

@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
	private TipoDocumentoRepositorio tipoDocumentoRepositorio;
	
	@Override
	public List<TipoDocumento> listadoTipoDocumento() {
		// TODO Auto-generated method stub
		return tipoDocumentoRepositorio.findAll();
	}

	public Optional<TipoDocumento> obtenerTipoDocumento(int id) {
	
		return tipoDocumentoRepositorio.findById((long) id);
	}
}
