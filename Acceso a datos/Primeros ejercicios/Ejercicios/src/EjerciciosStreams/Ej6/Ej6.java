package EjerciciosStreams.Ej6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ej6 {
    static void main() {
        List<Persona> personas = new ArrayList<>(List.of(
                new Persona("Ana García", "12345678A", new ArrayList<>(List.of(
                        new Coche("Seat", "Rojo", "1234BCD")
                ))),
                new Persona("Luis Martínez", "23456789B", new ArrayList<>(List.of(
                        new Coche("Toyota", "Azul", "2345CDE"),
                        new Coche("Ford", "Negro", "2346CDF")
                ))),
                new Persona("Marta López", "34567890C", new ArrayList<>()),
                new Persona("Pepe Sánchez", "45678901D", new ArrayList<>(List.of(
                        new Coche("BMW", "Blanco", "4567EFG")
                ))),
                new Persona("Sonia Ruiz", "56789012E", new ArrayList<>(List.of(
                        new Coche("Audi", "Gris", "5678FGH"),
                        new Coche("Renault", "Verde", "5679FGI")
                ))),
                new Persona("Raúl Fernández", "67890123F", new ArrayList<>(List.of(
                        new Coche("Peugeot", "Rojo", "6789GHI")
                ))),
                new Persona("Julia Gómez", "78901234G", new ArrayList<>()),
                new Persona("Iván Díaz", "89012345H", new ArrayList<>(List.of(
                        new Coche("Citroën", "Azul", "8901HIJ")
                ))),
                new Persona("Clara Moreno", "90123456I", new ArrayList<>(List.of(
                        new Coche("Hyundai", "Negro", "9012IJK"),
                        new Coche("Kia", "Blanco", "9013IJL")
                ))),
                new Persona("Diego Álvarez", "01234567J", new ArrayList<>(List.of(
                        new Coche("Mercedes", "Plata", "0123JKL")
                ))),
                new Persona("Nora Romero", "11223344K", new ArrayList<>()),
                new Persona("Óscar Navarro", "22334455L", new ArrayList<>(List.of(
                        new Coche("Volkswagen", "Rojo", "2233LMN")
                ))),
                new Persona("Belén Torres", "33445566M", new ArrayList<>(List.of(
                        new Coche("Mazda", "Azul", "3344MNO"),
                        new Coche("Honda", "Verde", "3345MNP")
                ))),
                new Persona("Víctor Domínguez", "44556677N", new ArrayList<>(List.of(
                        new Coche("Opel", "Gris", "4455NOP")
                ))),
                new Persona("Paula Vázquez", "55667788O", new ArrayList<>()),
                new Persona("Sergio Ramos", "66778899P", new ArrayList<>(List.of(
                        new Coche("Skoda", "Negro", "6677PQR")
                ))),
                new Persona("Irene Castro", "77889900Q", new ArrayList<>(List.of(
                        new Coche("Fiat", "Blanco", "7788QRS"),
                        new Coche("Fiat", "Verde", "7798QRS"),
                        new Coche("Nissan", "Rojo", "7789QRT")
                ))),
                new Persona("Tomás Ortega", "88990011R", new ArrayList<>(List.of(
                        new Coche("Volvo", "Azul", "8899RST")
                ))),
                new Persona("Laura Delgado", "99001122S", new ArrayList<>()),
                new Persona("Rubén Ibáñez", "00112233T", new ArrayList<>(List.of(
                        new Coche("Jeep", "Verde", "0011TUV")
                )))
        ));

        System.out.println("----- 1 -----");
        personas.stream().filter(a->a.getCoches().stream().anyMatch(b->b.getColor().equalsIgnoreCase("Rojo"))).forEach(System.out::println);

        System.out.println("----- 2 -----");
        personas.stream().filter(a->a.getCoches().stream().anyMatch(b->b.getMarca().equalsIgnoreCase("Opel"))).forEach(System.out::println);

        System.out.println("----- 3 -----");
        System.out.println(personas.stream().max(Comparator.comparing(a -> a.getCoches().size())));
        // System.out.println(personas.stream().max((a, b)-> a.getCoches().size()-b.getCoches().size()));

    }
}
