package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.UsuarioDTO;
import com.gestion.cargos.modelo.Usuario;
import com.gestion.cargos.repositorio.UsuarioRepository;
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
@RequestMapping("usuarios")
public class UserController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @GetMapping(name = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario: usuarios
             ) {
            UsuarioDTO dto = MHelpers.modelMapper().map(usuario, UsuarioDTO.class);
            usuariosDTO.add(dto);
        }

        return ResponseEntity.ok(usuariosDTO);
    }
}
