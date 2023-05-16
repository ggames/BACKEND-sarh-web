package com.gestion.cargos.controlador;

import com.gestion.cargos.dto.AgenteDTO;
import com.gestion.cargos.notification.EmailNotification;
import com.gestion.cargos.servicios.implementacion.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
     private EmailNotification emailNotification;

    @Autowired
    private AsynchronousService asynchronousService;

    @PostMapping(value = "/send")
    @ResponseBody
    public void SendEmail(){
         emailNotification.sendNotification();
    }


    @GetMapping("/")
    public ResponseEntity <List<AgenteDTO>>AgenteNotification(){
        return ResponseEntity.ok( asynchronousService.findAgenteJubilacion());
    }

}
