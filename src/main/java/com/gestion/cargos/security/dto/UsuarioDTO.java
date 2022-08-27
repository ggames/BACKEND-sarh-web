package com.gestion.cargos.security.dto;

import com.gestion.cargos.security.entity.Rol;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDTO {

    private String nombre;

    private String nombreUsuario;

    private String email;

    private List<Rol> roles = new ArrayList<>();

}
