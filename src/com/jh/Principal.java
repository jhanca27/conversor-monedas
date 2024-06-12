package com.jh;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jh.models.Conversor;
import com.jh.utils.ConexionAPI;
import com.jh.utils.CrearUrl;
import com.jh.utils.Json;
import com.jh.utils.Response;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lector = new Scanner(System.in);
        List<Conversor> listaConversiones = new ArrayList<>();
        //lector.close();
        //System.out.println("Ingresa tu api key: ");
        //String apiKey = lector.nextLine();
        String apiKey = System.getenv("API_KEY_EXCHANGER");
        String monedaBase = "";
        String monedaAConvertir = "";

        while(true){
            imprimirMensaje();
            String seleccion = lector.next();
            String[] arreglo = tabla(seleccion);
            if (seleccion.equals("7")){
                break;
            }else if(arreglo[2].equals("8")){
                continue;
            }
            monedaBase = arreglo[0];
            monedaAConvertir = arreglo[1];

            double valor = solicitarValorConversion(lector);
            
            String url = CrearUrl.url(apiKey, monedaBase, monedaAConvertir,lector,valor);
            HttpResponse<String> response = ConexionAPI.conexion(url);
            Conversor conversor = Response.manejoResponse(response, valor);
            if(response.statusCode() == 200){
                listaConversiones.add(conversor);
            }
        }
        lector.close();
        if(!listaConversiones.isEmpty()){
            Json.generarJson(listaConversiones);
        }else{
            System.out.println("No guardó ninguna conversion correcta");
        }
  
    }

    public static void imprimirMensaje(){
        System.out.println("""
                **********************************************************
                Bienvenido al conversor de Monedas:

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) salir
                Elija una opción valida:
                **********************************************************
                """);
    }

    public static String[] tabla(String seleccion){
        String monedaBase = "";
        String monedaAConvertir = "";
        switch (seleccion) {
            case "1":
                monedaBase = "USD";
                monedaAConvertir = "ARS";
                break;
            case "2":
                monedaBase = "ARS";
                monedaAConvertir = "USD";
                break;
            case "3":
                monedaBase = "USD";
                monedaAConvertir = "BRL";
                break;
            case "4":
                monedaBase = "BRL";
                monedaAConvertir = "USD";
                break;
            case "5":
                monedaBase = "USD";
                monedaAConvertir = "COP";
                break;
            case "6":
                monedaBase = "COP";
                monedaAConvertir = "USD";
                break;
            case "7":
                System.out.println("Gracias por utilizar el conversor de monedas");
                break;

            default:
                seleccion= "8";
                System.out.println("Opción no valida, por favor selecciona una opción valida");
                break;
        }
        String[] arreglo = new String[3];
        arreglo[0]=monedaBase;
        arreglo[1]=monedaAConvertir;
        arreglo[2]=seleccion;
        return arreglo;
    }

    public static double solicitarValorConversion(Scanner lector){
        double valor = 0;
        while (true) {
            try {
                System.out.println("Digite la cantidad que desea convertir:");
                String valorConvertir = lector.next();
                valor = Double.valueOf(valorConvertir);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("No has ingresado un numero");
            }
            
        }
        return valor;
    }
}
