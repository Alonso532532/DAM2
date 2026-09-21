package UrgenciasComparable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EjercicioUrgencias {
    static void main() {
        // Le asigno el orden de primeras
        PriorityQueue<Paciente> cola = new PriorityQueue<>();

        cola.addAll(List.of(
                new Paciente("Ana",    5,  LocalDateTime.of(2026, 9, 16, 10, 1)),
                new Paciente("Luis",   9,  LocalDateTime.of(2026, 9, 16, 10, 2)),
                new Paciente("Marta",  9,  LocalDateTime.of(2026, 9, 16, 10, 3)),
                new Paciente("Pepe",   3,  LocalDateTime.of(2026, 9, 16, 10, 4)),
                new Paciente("Sonia",  7,  LocalDateTime.of(2026, 9, 16, 10, 5)),
                new Paciente("Raúl",   4,  LocalDateTime.of(2026, 9, 16, 10, 6)),
                new Paciente("Julia",  10, LocalDateTime.of(2026, 9, 16, 10, 7)),
                new Paciente("Iván",   6,  LocalDateTime.of(2026, 9, 16, 10, 8)),
                new Paciente("Clara",  8,  LocalDateTime.of(2026, 9, 16, 10, 9)),
                new Paciente("Diego",  2,  LocalDateTime.of(2026, 9, 16, 10, 10)),
                new Paciente("Nora",   10, LocalDateTime.of(2026, 9, 16, 10, 11)),
                new Paciente("Óscar",  1,  LocalDateTime.of(2026, 9, 16, 10, 12)),
                new Paciente("Belén",  7,  LocalDateTime.of(2026, 9, 16, 10, 13)),
                new Paciente("Víctor", 5,  LocalDateTime.of(2026, 9, 16, 10, 14)),
                new Paciente("Paula",  9,  LocalDateTime.of(2026, 9, 16, 10, 15)),
                new Paciente("Sergio", 4,  LocalDateTime.of(2026, 9, 16, 10, 16)),
                new Paciente("Irene",  6,  LocalDateTime.of(2026, 9, 16, 10, 17)),
                new Paciente("Tomás",  8,  LocalDateTime.of(2026, 9, 16, 10, 18)),
                new Paciente("Laura",  3,  LocalDateTime.of(2026, 9, 16, 10, 19)),
                new Paciente("Rubén",  7,  LocalDateTime.of(2026, 9, 16, 10, 20)),
                new Paciente("Pilar",  10, LocalDateTime.of(2026, 9, 16, 10, 21)),
                new Paciente("Andrés", 2,  LocalDateTime.of(2026, 9, 16, 10, 22)),
                new Paciente("Carla",  9,  LocalDateTime.of(2026, 9, 16, 10, 23)),
                new Paciente("Mario",  6,  LocalDateTime.of(2026, 9, 16, 10, 24)),
                new Paciente("Elena",  8,  LocalDateTime.of(2026, 9, 16, 10, 25)),
                new Paciente("Fabián", 4,  LocalDateTime.of(2026, 9, 16, 10, 26)),
                new Paciente("Rosa",   5,  LocalDateTime.of(2026, 9, 16, 10, 27)),
                new Paciente("David",  7,  LocalDateTime.of(2026, 9, 16, 10, 28)),
                new Paciente("Silvia", 3,  LocalDateTime.of(2026, 9, 16, 10, 29)),
                new Paciente("Héctor", 9,  LocalDateTime.of(2026, 9, 16, 10, 30))
        ));

        // La propia cola usa su sistema para ordenarlo, asique da problemas al imprimirlo
        // cola.stream().sorted(new ComparadorPacientes()).forEach(System.out::println);

        // Al usar el sistema de ordenación y sacar el primer elemento los saca de forma ordenada
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }

        ArrayList<Paciente> pruebica = new ArrayList<>(Arrays.asList(
                new Paciente("Ana",    5,  LocalDateTime.of(2026, 9, 16, 10, 1)),
                new Paciente("Luis",   9,  LocalDateTime.of(2026, 9, 16, 10, 2)),
                new Paciente("Marta",  9,  LocalDateTime.of(2026, 9, 16, 10, 3)),
                new Paciente("Pepe",   3,  LocalDateTime.of(2026, 9, 16, 10, 4)),
                new Paciente("Sonia",  7,  LocalDateTime.of(2026, 9, 16, 10, 5)),
                new Paciente("Raúl",   4,  LocalDateTime.of(2026, 9, 16, 10, 6)),
                new Paciente("Julia",  10, LocalDateTime.of(2026, 9, 16, 10, 7)),
                new Paciente("Iván",   6,  LocalDateTime.of(2026, 9, 16, 10, 8)),
                new Paciente("Clara",  8,  LocalDateTime.of(2026, 9, 16, 10, 9)),
                new Paciente("Diego",  2,  LocalDateTime.of(2026, 9, 16, 10, 10)),
                new Paciente("Nora",   10, LocalDateTime.of(2026, 9, 16, 10, 11)),
                new Paciente("Óscar",  1,  LocalDateTime.of(2026, 9, 16, 10, 12)),
                new Paciente("Belén",  7,  LocalDateTime.of(2026, 9, 16, 10, 13)),
                new Paciente("Víctor", 5,  LocalDateTime.of(2026, 9, 16, 10, 14)),
                new Paciente("Paula",  9,  LocalDateTime.of(2026, 9, 16, 10, 15)),
                new Paciente("Sergio", 4,  LocalDateTime.of(2026, 9, 16, 10, 16)),
                new Paciente("Irene",  6,  LocalDateTime.of(2026, 9, 16, 10, 17)),
                new Paciente("Tomás",  8,  LocalDateTime.of(2026, 9, 16, 10, 18)),
                new Paciente("Laura",  3,  LocalDateTime.of(2026, 9, 16, 10, 19)),
                new Paciente("Rubén",  7,  LocalDateTime.of(2026, 9, 16, 10, 20)),
                new Paciente("Pilar",  10, LocalDateTime.of(2026, 9, 16, 10, 21)),
                new Paciente("Andrés", 2,  LocalDateTime.of(2026, 9, 16, 10, 22)),
                new Paciente("Carla",  9,  LocalDateTime.of(2026, 9, 16, 10, 23)),
                new Paciente("Mario",  6,  LocalDateTime.of(2026, 9, 16, 10, 24)),
                new Paciente("Elena",  8,  LocalDateTime.of(2026, 9, 16, 10, 25)),
                new Paciente("Fabián", 4,  LocalDateTime.of(2026, 9, 16, 10, 26)),
                new Paciente("Rosa",   5,  LocalDateTime.of(2026, 9, 16, 10, 27)),
                new Paciente("David",  7,  LocalDateTime.of(2026, 9, 16, 10, 28)),
                new Paciente("Silvia", 3,  LocalDateTime.of(2026, 9, 16, 10, 29)),
                new Paciente("Héctor", 9,  LocalDateTime.of(2026, 9, 16, 10, 30))
        ));

        System.out.println("------------------------");
        pruebica.stream().sorted().forEach(System.out::println);
    }
}
