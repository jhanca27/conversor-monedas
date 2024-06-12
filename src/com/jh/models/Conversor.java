package com.jh.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Conversor  {
    private String monedaBase;
    private String monedaAConvertir;
    private double tasaConversion;
    private double resultadoConversion;
    private LocalDateTime ultimaActualizacion;
    private double cantidadAConvertir;


    public Conversor(ConversorRecord conversorRecord,double cantidadAConvertir){
        this.monedaBase = conversorRecord.base_code();
        this.monedaAConvertir = conversorRecord.target_code();
        this.tasaConversion = convertirToDouble(conversorRecord.conversion_rate());
        this.resultadoConversion = convertirToDouble(conversorRecord.conversion_result());
        this.ultimaActualizacion = convertirToLocalDateTime(conversorRecord.time_last_update_utc());
        this.cantidadAConvertir = cantidadAConvertir;
    }


    private LocalDateTime convertirToLocalDateTime(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        try {
            return LocalDateTime.parse(fecha, formatter);
        } catch (DateTimeParseException  e) {
            System.out.println("Formato de fecha, no adecuado");
            return null;
        }
        
    }

    private double convertirToDouble(String doubleNumber){
        double valor = 0;
        if(doubleNumber.isEmpty() || doubleNumber.isBlank()){
            return valor;
        }
        try {
            valor = Double.valueOf(doubleNumber);    
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return valor;
    }


    public String getMonedaBase() {
        return monedaBase;
    }


    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }


    public double getTasaConversion() {
        return tasaConversion;
    }


    public double getResultadoConversion() {
        return resultadoConversion;
    }


    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public double getCantidadAConvertir(){
        return this.cantidadAConvertir;
    }

    @Override
    public String toString() {
        return String.format("""
            
                *******************************************
                Moneda base: '%2s'
                Moneda a convertir: '%2s'
                Tasa de conversión: %2f
                Cantidad a convertir : %.2f
                *******************************************
                Resultado de conversión: %2f
                *******************************************
                Fecha ultima actualizacion de datos: %2s
                *******************************************
                """, monedaBase, monedaAConvertir, tasaConversion, cantidadAConvertir, resultadoConversion, ultimaActualizacion.toLocalDate());
    }


}
