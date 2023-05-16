package com.gestion.cargos.servicios.implementacion;

import com.gestion.cargos.dto.AgenteDTO;
import com.gestion.cargos.modelo.EmailBody;
import com.gestion.cargos.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsynchronousService {

    @Autowired
    AgenteServicioImpl agenteServicio;

    @Autowired
    DateUtils dateUtils;

    @Autowired
    EmailService emailService;

    private AsyncResult<EmailBody> result = new AsyncResult<EmailBody>(null);

    @Async
    public void notification() {
        //long now = System.currentTimeMillis()/1000;
        // System.out.println("schedule task using jobs: " + now);
        List<AgenteDTO> agentes = findAgenteJubilacion();
        for (AgenteDTO agente : agentes
        ) {

            String content = MessageFormat.format("Estimado {0}  {1} usted se encuentra en edad para comenzar el tramite jubilatorio", agente.getApellido(), agente.getNombre());
            EmailBody email = new EmailBody();
            email.setContent(content);
            email.setEmail("arialgames@yahoo.com.ar");
            email.setSubject("Inicio tramite Jubilatorio");
            emailService.sendEmail(email);
        }



    }

    public AsyncResult<EmailBody> getResult(){
        return  result;
    }

    public List<AgenteDTO> findAgenteJubilacion() {
        List<AgenteDTO> agentes = this.agenteServicio.findAll();
        List<AgenteDTO> agentesJubilacion = new ArrayList<>();
        for (AgenteDTO agente : agentes
        ) {
            Date fecha = new Date();
            Date fechaNac = agente.getFechaNac();

            int edad = dateUtils.calcularEdad(fechaNac, fecha);
            //logger.info("EDAD: edad " + edad );
            if (edad >= 50) {
                agentesJubilacion.add(agente);
            }
           // agentesJubilacion.add(agente);
        }
        return agentesJubilacion;
    }

}
