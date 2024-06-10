package com.jh.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jh.models.Conversor;

public class Json {
    public static void generarJson(List<Conversor> lista) throws IOException{
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
        //String hora = String.valueOf(LocalDateTime.now().toLocalTime().toNanoOfDay());
        LocalDateTime hoy = LocalDateTime.now();
        String hora = String.valueOf(hoy.toLocalDate())+"-"+ String.valueOf(hoy.getMinute()) + String.valueOf(hoy.getSecond()) ;
        FileWriter escritura = new FileWriter("conversiones"+hora+".json");
        escritura.write(gson.toJson(lista));
        escritura.close();
    }
}
