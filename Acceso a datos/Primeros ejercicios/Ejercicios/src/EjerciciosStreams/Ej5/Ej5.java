package EjerciciosStreams.Ej5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ej5 {
    static void main() {
        String cadena = "Crea un String con un contenido bastante largo. Ahora trabaja con dicho String para obtener por medio de stream el número de ocurrencias de cada palabra.";

        System.out.println(Arrays.stream(cadena.split(" ")).collect(Collectors.groupingBy(a -> a, Collectors.counting())));
    }
}
