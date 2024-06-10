package com.jh.utils;

import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jh.errors.ErrorResponse;
import com.jh.models.Conversor;
import com.jh.models.ConversorRecord;

public class Response {
    public static Conversor manejoResponse(HttpResponse<String> response, double valor){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if(response.statusCode() == 200){
            ConversorRecord datos = gson.fromJson(response.body(), ConversorRecord.class);
            Conversor conversor = new Conversor(datos, valor);
            System.out.println(conversor);
            return conversor;
        }

        if(response.statusCode() == 403){
            ErrorResponse errorResponse = gson.fromJson(response.body(), ErrorResponse.class);
            System.out.println(errorResponse.error);
        }

        if(response.statusCode() == 404){
            System.out.println("Url no tiene los parametros correctos");
        }

        return null;
    }
}
