package org.example.parte2;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    static void main() {
        Instant inicio = Instant.now();
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

        // <============================================= 2 - Creación del Mapa =============================================>

        MapaSincronizado mapaRegistrosPorMes = new MapaSincronizado();

        // Reparto la lista
        // Por cada hilo habrán aproximadamente 3 lotes
        Integer cantidadDelLote = 100;
        Integer cantidadDeLotes = archivos.size()/cantidadDelLote;
        Integer hilos = cantidadDeLotes/3;
        //System.out.println(lotes+" - "+hilos);

        List<TareaOrganizarRegistros> tareas = new ArrayList<>();

        for (int i = 0; i < cantidadDeLotes; i++) {
            tareas.add(new TareaOrganizarRegistros(archivos.subList(i*cantidadDelLote, (i+1)*cantidadDelLote),mapaRegistrosPorMes));

            //System.out.println(i*cantidadDelLote+"-"+(i+1)*cantidadDelLote);
        }
        // Los que sobren los añado por separado
        Integer sobrantes = archivos.size()%cantidadDelLote;
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
            //System.out.println(mapaRegistrosPorMes.contAnadidos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // <============================================= 3 - Conseguir máxima y mínima =============================================>

        List<Registro> listaCompleta = new ArrayList();

        for (ArrayList lista: mapaRegistrosPorMes.getRegistros().values()) {
            listaCompleta.addAll(lista);
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Registro> maxYMin = forkJoinPool.invoke(new TareaMaxYMin(listaCompleta));

        // <============================================= 4 - Datos por més en Teruel =============================================>

        List<TareaDatosTeruel> listaTareasDatosTeruel = new ArrayList<>();

        for (String mes: mapaRegistrosPorMes.getRegistros().keySet()) {
            listaTareasDatosTeruel.add(new TareaDatosTeruel(mapaRegistrosPorMes.getRegistros().get(mes)));
        }

        ForkJoinTask.invokeAll(listaTareasDatosTeruel);
        List<DatosTeruel> resultadosTeruel = listaTareasDatosTeruel.stream()
                .map(ForkJoinTask::join)
                .toList();

        resultadosTeruel.forEach(System.out::println);



        // <============================================= Tiempo =============================================>

        Duration duracion = Duration.between(inicio, Instant.now());
        System.out.println("\nTiempo: " + duracion.toMillis() + " ms");
        //System.out.println(tareasRes.size());

        // <============================================= PRUEBAS =============================================>



//        System.out.println("Pruebas");

        //System.out.println(archivos.size());
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

//        System.out.println(mapaRegistrosPorMes.registros.keySet());


//        System.out.println(setMes.size());
//
//
//        //System.out.println(resultados.length);
//
//        //System.out.println(lotesReg+" - "+hilosReg);
//        for (String mes: setMes){
//            List<Registro> regs = mapaRegistrosPorMes.registros.get(mes);
//
//            Registro regTmax = regs.stream().filter(a->a.getTmax()!=null).max(Comparator.comparing(Registro::getTmax)).get();
//            Registro regTmin = regs.stream().filter(a->a.getTmin()!=null).min(Comparator.comparing(Registro::getTmin)).get();
//
//            System.out.println("<=============== "+mes+" ===============>\nTemperatura maxima: "+regTmax+"\nTemperatura minima: "+regTmin);
//        }
    }
}
