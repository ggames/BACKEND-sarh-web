package com.gestion.cargos.security.utils;

import com.gestion.cargos.enums.ECargoNombre;
import com.gestion.cargos.enums.cCaracterNombre;
import com.gestion.cargos.modelo.CargoCaracter;
import com.gestion.cargos.modelo.EstadoCargo;
import com.gestion.cargos.security.entity.Rol;
import com.gestion.cargos.security.enums.RolNombre;
import com.gestion.cargos.security.service.RolService;

import com.gestion.cargos.servicios.implementacion.CaracterCargoServicioImpl;
import com.gestion.cargos.servicios.implementacion.EstadoCargoServicioImpl;
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

    @Autowired
    CaracterCargoServicioImpl caracterCargoServicio;

    @Autowired
    EstadoCargoServicioImpl estadoCargoServicio;
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN, "admin");
        Rol rolUser = new Rol(RolNombre.ROLE_USER, "user");
        Rol rolPersonal = new Rol(RolNombre.ROLE_PERSONAL, "personal");
        Rol rolDirector = new Rol(RolNombre.ROLE_DIRECTOR, "director");

        CargoCaracter ordinario = new CargoCaracter(cCaracterNombre.ORDINARIO, "Ordinario");
        CargoCaracter interino = new CargoCaracter(cCaracterNombre.INTERINO, "Interino");
        CargoCaracter contratado = new CargoCaracter(cCaracterNombre.CONTRATADO, "Contratado");
        CargoCaracter reemplazante = new CargoCaracter(cCaracterNombre.REEMPLAZANTE, "Reemplazante");

/*
        caracterCargoServicio.save(ordinario);
        caracterCargoServicio.save(interino);
        caracterCargoServicio.save(contratado);
        caracterCargoServicio.save(reemplazante);
*/

        EstadoCargo vacante_def = new EstadoCargo(ECargoNombre.VACANTE_DEFINITIVA, "Vacante Defenitiva");
        EstadoCargo vacante_trans = new EstadoCargo(ECargoNombre.VACANTE_TRANSITORIA, "Vacante Transitoria");
        EstadoCargo congelado = new EstadoCargo(ECargoNombre.CONGELADO, "Congelado");
        EstadoCargo solicitada = new EstadoCargo(ECargoNombre.SOLICITADA, "Solicitada");
        EstadoCargo ocupado = new EstadoCargo(ECargoNombre.OCUPADO, "Ocupado");
       /* estadoCargoServicio.save(vacante_def);
        estadoCargoServicio.save(vacante_trans);
        estadoCargoServicio.save(congelado);
        estadoCargoServicio.save(solicitada);
*/
        // estadoCargoServicio.save(ocupado);
     /*   rolService.save(rolPersonal);
        rolService.save(rolDirector);

        rolService.save(rolAdmin);
        rolService.save(rolUser);*/
         
    }
}
