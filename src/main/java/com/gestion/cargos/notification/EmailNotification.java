package com.gestion.cargos.notification;

import com.gestion.cargos.servicios.implementacion.AsynchronousService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsynchronousService asynchronousService;

    //@Scheduled(cron = "0 36 20 ? * *")
    public void sendNotification(){

        this.asynchronousService.notification();

        this.asynchronousService.getResult().cancel(true);
    }

//

}