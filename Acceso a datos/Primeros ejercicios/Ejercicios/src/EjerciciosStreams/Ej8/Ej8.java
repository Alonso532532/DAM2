package EjerciciosStreams.Ej8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej8 {
    static void main() {
        List<Cancion> canciones = new ArrayList<>(Arrays.asList(
                        new Cancion("Livin' on Prayer", "Bon Jovi"),
                        new Cancion("Long Hot Summer", "Keith Urban"),
                        new Cancion("It's my Life", "Bon Jovi"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("Dolor Fantasma", "Amadeus"),
                        new Cancion("Run To You", "Bryan Adams"),
                        new Cancion("Summer of 69", "Bryan Adams"),
                        new Cancion("Paranoid", "Black Sabbath"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("River Bank", "Brad Paisley")
        ));

        System.out.println("----- 1 -----");
        List<Cancion> BonJovi = new ArrayList<>();

        canciones.forEach(a-> {
            if (a.cantante.equals("Bon Jovi")){
                BonJovi.add(a);
            }
        });

        BonJovi.forEach(System.out::println);

        System.out.println("----- 2 -----");
        canciones.stream().filter(a->a.cantante.equals("Bon Jovi")).forEach(System.out::println);

        System.out.println("----- 3 -----");
        List<Cancion> BonJoviDos = new ArrayList<>(canciones.stream().filter(a->a.cantante.equals("Bon Jovi")).toList());
        BonJoviDos.forEach(System.out::println);

        System.out.println("----- 4 -----");
        System.out.println(canciones.stream().filter(a -> a.cantante.equals("Bon Jovi")).count());

        System.out.println("----- 5 -----");
        System.out.println(canciones.stream().collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting())));

        System.out.println("----- 6 -----");
        canciones.stream().distinct().forEach(System.out::println);

    }
}
