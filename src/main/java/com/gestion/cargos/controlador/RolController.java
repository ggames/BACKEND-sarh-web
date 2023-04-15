package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.RolDTO;
import com.gestion.cargos.modelo.Rol;
import com.gestion.cargos.repositorio.RolRepository;
import com.gestion.cargos.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RolController {
    @Autowired
    RolRepository rolRepository;
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolDTO>> findAll() {
        Iterable<Rol> roles = rolRepository.findAll();

        List<RolDTO> rolesDTO = new ArrayList<>();
        for (Rol rol : roles
        ) {
           RolDTO dto = MHelpers.modelMapper().map(rol, RolDTO.class);
           rolesDTO.add(dto);
        }

        return ResponseEntity.ok(rolesDTO);
    }
}
