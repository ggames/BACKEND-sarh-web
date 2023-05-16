package com.gestion.cargos.modelo;

import lombok.Data;

@Data
public class EmailBody {

    private String email;
    private String content;
    private String subject;

    @Override
    public String toString() {
        return "EmailBody [email=" + email + ", content=" + content + ", subject=" + subject + "]";
    }
}
