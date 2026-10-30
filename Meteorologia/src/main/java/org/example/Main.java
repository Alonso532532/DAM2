package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Plan
// 1 - Añadir los nombres de los archivos a una lista para despues separar y repartir esa lista <x>
// 2 - Repartir la lista entre hilos, sacar los datos de cada archivo y transformarlos a objetos <>
// 3 - En esas mismas tareas se guardarán los objetos en un Map<String, List<Registro>> <>
// 4 - Finalmente se reparte en tareas el proceso de leer todas esas listas y hacer un mega String con los datos de cada més

public class Main {
    static void main() {
        // <============================================= 1 - LISTA DE RUTAS =============================================>
        List<Path> archivos = new ArrayList<>();

        // Guardo las rutas en una lista
        Path dir = Path.of("src/main/java/org/example/registros");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path: stream) {
                archivos.add(path);
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }

        // <============================================= 2 - Hilos y 3 - Mapa =============================================>

        MapaSincronizado mapaRegistrosPorMes = new MapaSincronizado();




        // Tamaño
        //System.out.println("Tamaño: "+archivos.size());

        // <============================================= PRUEBAS =============================================>

//        System.out.println("Pruebas");
       try {

           String str = Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString();
           System.out.println(str);

           Matcher matcher = Pattern.compile("\",\"").matcher(Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString());
           String cad = matcher.replaceAll("\"'\"");
           cad = cad.replace(",",".").replace("'", ",");

           System.out.println(cad);

           Gson gson = new Gson();
           Registro reg = gson.fromJson(cad, Registro.class);
           reg.calcularFecha();
           System.out.println(reg);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
