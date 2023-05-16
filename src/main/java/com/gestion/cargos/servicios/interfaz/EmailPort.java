package com.gestion.cargos.servicios.interfaz;

import com.gestion.cargos.modelo.EmailBody;

public interface EmailPort {

    public boolean sendEmail(EmailBody emailBody);
}
