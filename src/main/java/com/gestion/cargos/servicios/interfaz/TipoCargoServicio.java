package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.dto.TipoCargoDTO;
import com.gestion.cargos.dto.TipoCargoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoCargoServicio {
    List<TipoCargoDTO> findAll();

    TipoCargoDTO findByTipoCargoId(Long id);

    public void save(TipoCargoRequest request);

    public void update(Long id, TipoCargoRequest request);

    public boolean existTipoCargo(Long id);
}
