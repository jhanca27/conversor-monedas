package com.jh.utils;

import java.util.Scanner;

public class CrearUrl {
    private static final String URLBASE= "https://v6.exchangerate-api.com/v6/";
    private static final String ACTION= "/pair";
    public static String url(String apiKey,String monedaBase,String monedaAConvertir, Scanner lector,double valor){
        String url = URLBASE + apiKey + ACTION;
        url+="/"+monedaBase+"/"+monedaAConvertir+"/"+valor;
        return url;
    }
}
