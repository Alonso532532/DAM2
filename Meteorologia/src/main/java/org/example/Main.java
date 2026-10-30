package org.example;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Plan
// 1 - Añadir los nombres de los archivos a una lista para despues separar y repartir esa lista <x>
// 2 - Repartir la lista entre tareas, sacar los datos de cada archivo y transformarlos a objetos, En esas mismas tareas se guardarán los objetos en un Map<String, List<Registro>> <>
// 3 - Finalmente se reparte en tareas el proceso de leer todas esas listas, organizarlas y hacer un mega String con los datos de cada més

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

        // <============================================= 2 - Tareas =============================================>

        MapaSincronizado mapaRegistrosPorMes = new MapaSincronizado();

        // Reparto la lista
        Integer lotes = 100;
        Integer hilos = 100;

        List<TareaOrganizarRegistros> tareas = new ArrayList<>();

        for (int i = 0; i < archivos.size()/lotes; i++) {
            tareas.add(new TareaOrganizarRegistros(archivos.subList(i*lotes, (i+1)*lotes),mapaRegistrosPorMes));

            //System.out.println(i*lotes+"-"+(i+1)*lotes);
        }
        // Los que sobren los añado por separado
        Integer sobrantes = archivos.size()%lotes;
        if (sobrantes!=0){
            tareas.add(new TareaOrganizarRegistros(archivos.subList(archivos.size()-sobrantes, archivos.size()),mapaRegistrosPorMes));

            //System.out.println((archivos.size()-sobrantes+" - "+archivos.size()));
        }

        // Hago el ThreadPoool
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(hilos);

        for (Runnable tarea : tareas) {
            executor.execute(tarea);
        }

        //System.out.println(archivos.size()/lotes+1);

        try {
            // shutdown() cierra el executor entonces awaitTermination espera 1 minuto a que se procesen todas las tareas
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println(mapaRegistrosPorMes.contAnadidos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Tamaño
        //System.out.println("Tamaño: "+archivos.size());

        // <============================================= PRUEBAS =============================================>


//        System.out.println("Pruebas");
//       try {
//
//           String str = Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString();
//           System.out.println(str);
//
//           Matcher matcher = Pattern.compile("\",\"").matcher(Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString());
//           String cad = matcher.replaceAll("\"'\"");
//           cad = cad.replace(",",".").replace("'", ",");
//
//           System.out.println(cad);
//
//           Gson gson = new Gson();
//           Registro reg = gson.fromJson(cad, Registro.class);
//           reg.calcularFecha();
//           System.out.println(reg);
//
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }

//        Thread hiloPrueba = new Thread(new TareaOrganizarRegistros(archivos.subList(0, 100), mapaRegistrosPorMes));
//
//        hiloPrueba.start();
//        try {
//            hiloPrueba.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(mapaRegistrosPorMes.contAnadidos);
//        System.out.println(mapaRegistrosPorMes.registros.get("2018-10"));

//        AtomicReference<Integer> acum = new AtomicReference<>(0);
//        tareas.forEach(a->{
//            acum.updateAndGet(v -> v + a.archivos.size());
//        });
//        System.out.println(acum);
//        System.out.println(archivos.size());
    }
}
