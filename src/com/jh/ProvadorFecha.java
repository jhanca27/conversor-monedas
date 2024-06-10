package com.jh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProvadorFecha {

    public static void main(String[] args) {
        String fecha = "Sat, 08 Jun 2024 00:00:02 +0000";

        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;

        LocalDateTime ldt = LocalDateTime.parse(fecha, formatter);
        System.out.println(ldt.toLocalDate());
        System.out.println(ldt);
        String hola = "hico";
        double numero = 2.6217;
        System.out.println(String.format("""
            %2$2s , %1$.3f
        """, numero,hola));
    }
}
