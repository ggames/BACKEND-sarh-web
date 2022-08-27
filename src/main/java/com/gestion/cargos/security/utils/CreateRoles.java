package com.gestion.cargos.security.utils;

import com.gestion.cargos.security.entity.Rol;
import com.gestion.cargos.security.enums.RolNombre;
import com.gestion.cargos.security.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN, "admin");
        Rol rolUser = new Rol(RolNombre.ROLE_USER, "user");
        Rol rolPersonal = new Rol(RolNombre.ROLE_PERSONAL, "personal");
        Rol rolDirector = new Rol(RolNombre.ROLE_DIRECTOR, "director");

     /*   rolService.save(rolPersonal);
        rolService.save(rolDirector);

        rolService.save(rolAdmin);
        rolService.save(rolUser);*/
         
    }
}
