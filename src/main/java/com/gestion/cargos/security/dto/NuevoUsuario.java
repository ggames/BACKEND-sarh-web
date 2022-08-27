package com.gestion.cargos.security.dto;

import com.gestion.cargos.security.entity.Rol;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class NuevoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @Email
    private String email;
    @NotBlank
    private String password;

    private List<String> roles = new ArrayList<>();


}
