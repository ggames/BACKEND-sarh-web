package com.gestion.cargos.security.controller;

import com.gestion.cargos.dto.RolDTO;
import com.gestion.cargos.security.entity.Rol;
import com.gestion.cargos.security.repository.RolRepository;
import com.gestion.cargos.utils.MHelpers;
import org.apache.catalina.valves.rewrite.Substitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("roles")
public class RolController {
    @Autowired
    RolRepository rolRepository;
    @GetMapping(name = "", produces = MediaType.APPLICATION_JSON_VALUE)
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
