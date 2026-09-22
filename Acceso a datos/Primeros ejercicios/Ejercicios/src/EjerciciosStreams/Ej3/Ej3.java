package EjerciciosStreams.Ej3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ej3 {
    static void main() {
        List<Persona> personas = new ArrayList<>(List.of(
                new Persona("Marta", 28),
                new Persona("Carlos", 34),
                new Persona("Lucía", 19),
                new Persona("Javier", 45),
                new Persona("Elena", 22),
                new Persona("Andrés", 31)
        ));

        System.out.println("--- Edad promedio ---");
        System.out.println(personas.stream().mapToInt(Persona::getEdad).average());
        System.out.println("--- Más joven ---");
        System.out.println(personas.stream().sorted(Comparator.comparing(Persona::getEdad)).limit(1).toList().getFirst());
        System.out.println("--- Edad > 30 ---");
        System.out.println(personas.stream().filter(a->a.getEdad()>30).toList());
    }
}
