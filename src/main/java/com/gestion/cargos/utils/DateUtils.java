package com.gestion.cargos.utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateUtils {

    public int calcularEdad(Date fechaNacimiento, Date fecha){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(fechaNacimiento));
        int d2 = Integer.parseInt(formatter.format(fecha));
        int edad = (d2 - d1)/10000;
        return edad;
    }

    public int calcularEdad(String fecha){
        Date fechaNac = null;
        try {

            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

        }catch (Exception ex){
            System.out.println("Error :"  + ex);
        }

        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();

        fechaNacimiento.setTime(fechaNac);
        int anio = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);

        if(mes < 0 || (mes == 0 &&  dia< 0)){
            anio--;
        }

        return anio;
    }
}
