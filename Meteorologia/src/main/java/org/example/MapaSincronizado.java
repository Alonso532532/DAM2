package org.example;

import java.util.*;

public class MapaSincronizado {
    // Aquí se agruparan los registros por su més <Mes, Registros>
    Map<String, ArrayList<Registro>> registros = new LinkedHashMap<>();
    Integer contAnadidos = 0;

    public synchronized void anadirRegistro(Registro r){
        if (registros.get(r.getMesYAno())==null){
            registros.put(r.getMesYAno(), new ArrayList<>(List.of(r)));
        } else {
            registros.get(r.getMesYAno()).add(r);
        }
        contAnadidos++;
        //System.out.println(contAnadidos);
    }
}
