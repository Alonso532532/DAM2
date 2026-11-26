import java.time.LocalDateTime;
import java.util.*;

public class Hospital {
    static void main() {
        Queue<Paciente> cola = new PriorityQueue<>(obtenerPacientes());

        System.out.println("Paciente de prioridad 1 con más edad");
        System.out.println(cola.stream().filter(p -> p.getGravedad()==1).max(Comparator.comparing(Paciente::getEdad)).orElseThrow(()->new RuntimeException("No hay")));

        System.out.print("Suma edades: ");
        System.out.println(cola.stream().mapToInt(Paciente::getEdad).reduce(Integer::sum).getAsInt());

        System.out.print("Media de gravedad: ");
        System.out.println(cola.stream().mapToInt(Paciente::getGravedad).average().getAsDouble());

        Map<String, Integer> mapa = new HashMap<>();

        cola.forEach(paciente -> {
            mapa.put(paciente.getNombre(), mapa.get(paciente.getNombre())==null?1:mapa.get(paciente.getNombre())+1);
        });

        System.out.println(mapa);


//        while (!cola.isEmpty()) {
//            System.out.println(cola.poll());
//        }
    }

    public static List<Paciente> obtenerPacientes() {
        LocalDateTime base = LocalDateTime.of(2026, 11, 26, 8, 0);

        return new ArrayList<>(List.of(
                new Paciente("Antonio García", base.plusMinutes(0), 4, 67),
                new Paciente("María López", base.plusMinutes(3), 7, 45),
                new Paciente("José Martínez", base.plusMinutes(6), 2, 23),
                new Paciente("Carmen Sánchez", base.plusMinutes(9), 9, 81),
                new Paciente("Manuel Pérez", base.plusMinutes(12), 5, 56),
                new Paciente("Laura Gómez", base.plusMinutes(15), 1, 19),
                new Paciente("David Ruiz", base.plusMinutes(18), 8, 72),
                new Paciente("Ana Fernández", base.plusMinutes(21), 3, 34),
                new Paciente("Javier Díaz", base.plusMinutes(24), 10, 88),
                new Paciente("Lucía Moreno", base.plusMinutes(27), 6, 41),
                new Paciente("Carlos Jiménez", base.plusMinutes(30), 2, 8),
                new Paciente("Marta Navarro", base.plusMinutes(33), 7, 63),
                new Paciente("Pablo Torres", base.plusMinutes(36), 4, 29),
                new Paciente("Elena Romero", base.plusMinutes(39), 9, 77),
                new Paciente("Sergio Alonso", base.plusMinutes(42), 1, 15),
                new Paciente("Paula Gutiérrez", base.plusMinutes(45), 5, 52),
                new Paciente("Alberto Castro", base.plusMinutes(48), 8, 69),
                new Paciente("Sara Ortega", base.plusMinutes(51), 3, 38),
                new Paciente("Daniel Rubio", base.plusMinutes(54), 6, 47),
                new Paciente("Irene Molina", base.plusMinutes(57), 10, 91),
                new Paciente("Raúl Delgado", base.plusMinutes(60), 2, 26),
                new Paciente("Cristina Serrano", base.plusMinutes(63), 7, 58),
                new Paciente("Álvaro Blanco", base.plusMinutes(66), 4, 33),
                new Paciente("Nuria Suárez", base.plusMinutes(69), 9, 84),
                new Paciente("Hugo Ramos", base.plusMinutes(72), 1, 6),
                new Paciente("Beatriz Vega", base.plusMinutes(75), 5, 61),
                new Paciente("Iván Herrero", base.plusMinutes(78), 8, 74),
                new Paciente("Silvia Cano", base.plusMinutes(81), 3, 22),
                new Paciente("Rubén Prieto", base.plusMinutes(84), 6, 49),
                new Paciente("Patricia Medina", base.plusMinutes(87), 10, 79),
                new Paciente("Adrián Flores", base.plusMinutes(90), 2, 17),
                new Paciente("Rosa Iglesias", base.plusMinutes(93), 7, 66),
                new Paciente("Fernando Cruz", base.plusMinutes(96), 4, 43),
                new Paciente("Pilar Garrido", base.plusMinutes(99), 9, 86),
                new Paciente("Jorge Santos", base.plusMinutes(102), 1, 12),
                new Paciente("Teresa Núñez", base.plusMinutes(105), 5, 54),
                new Paciente("Óscar Lozano", base.plusMinutes(108), 8, 71),
                new Paciente("Mónica Bravo", base.plusMinutes(111), 3, 31),
                new Paciente("Víctor Campos", base.plusMinutes(114), 6, 60),
                new Paciente("Inés Vázquez", base.plusMinutes(117), 10, 93),
                new Paciente("Marcos Ibáñez", base.plusMinutes(120), 2, 14),
                new Paciente("Natalia Reyes", base.plusMinutes(123), 7, 37),
                new Paciente("Guillermo Peña", base.plusMinutes(126), 4, 68),
                new Paciente("Alicia Marín", base.plusMinutes(129), 9, 82),
                new Paciente("Enrique Soto", base.plusMinutes(132), 1, 28),
                new Paciente("Julia Cabrera", base.plusMinutes(135), 5, 5),
                new Paciente("Andrés Gil", base.plusMinutes(138), 8, 76),
                new Paciente("Lorena Parra", base.plusMinutes(141), 3, 44),
                new Paciente("Ricardo Vidal", base.plusMinutes(144), 6, 55),
                new Paciente("Claudia Esteban", base.plusMinutes(147), 10, 89),
                new Paciente("Tomás Méndez", base.plusMinutes(150), 2, 21),
                new Paciente("Sofía Aguilar", base.plusMinutes(153), 7, 62),
                new Paciente("Diego Calvo", base.plusMinutes(156), 4, 36),
                new Paciente("Eva Montero", base.plusMinutes(159), 9, 78),
                new Paciente("Gonzalo Pascual", base.plusMinutes(162), 1, 9),
                new Paciente("Raquel Herrera", base.plusMinutes(165), 5, 50),
                new Paciente("Mario Lorenzo", base.plusMinutes(168), 8, 70),
                new Paciente("Verónica Nieto", base.plusMinutes(171), 3, 25),
                new Paciente("Lucas Giménez", base.plusMinutes(174), 6, 64),
                new Paciente("Amparo Fuentes", base.plusMinutes(177), 10, 85),
                new Paciente("Ángel Carrasco", base.plusMinutes(180), 2, 40),
                new Paciente("Sonia Crespo", base.plusMinutes(183), 7, 53),
                new Paciente("Nicolás Santana", base.plusMinutes(186), 4, 18),
                new Paciente("Gloria Arias", base.plusMinutes(189), 9, 80),
                new Paciente("Félix Pardo", base.plusMinutes(192), 1, 32),
                new Paciente("Rocío Durán", base.plusMinutes(195), 5, 46),
                new Paciente("Ismael Vicente", base.plusMinutes(198), 8, 73),
                new Paciente("Marina Cortés", base.plusMinutes(201), 3, 11),
                new Paciente("Joaquín Rojas", base.plusMinutes(204), 6, 59),
                new Paciente("Dolores Mora", base.plusMinutes(207), 10, 95),
                new Paciente("Samuel Ferrer", base.plusMinutes(210), 2, 27),
                new Paciente("Lidia Caballero", base.plusMinutes(213), 7, 48),
                new Paciente("Rafael Benítez", base.plusMinutes(216), 4, 65),
                new Paciente("Noelia Gallego", base.plusMinutes(219), 9, 83),
                new Paciente("Ignacio Hidalgo", base.plusMinutes(222), 1, 3),
                new Paciente("Alejandra Soler", base.plusMinutes(225), 5, 57),
                new Paciente("Emilio Pastor", base.plusMinutes(228), 8, 75),
                new Paciente("Yolanda Sanz", base.plusMinutes(231), 3, 35),
                new Paciente("Bruno Montes", base.plusMinutes(234), 6, 42),
                new Paciente("Esther Rivas", base.plusMinutes(237), 10, 87),
                new Paciente("Cristian León", base.plusMinutes(240), 2, 24),
                new Paciente("Miriam Bermúdez", base.plusMinutes(243), 7, 61),
                new Paciente("Héctor Vargas", base.plusMinutes(246), 4, 30),
                new Paciente("Carolina Lara", base.plusMinutes(249), 9, 90),
                new Paciente("Saúl Moya", base.plusMinutes(252), 1, 7),
                new Paciente("Belén Redondo", base.plusMinutes(255), 5, 51),
                new Paciente("Gabriel Cárdenas", base.plusMinutes(258), 8, 67),
                new Paciente("Ángela Román", base.plusMinutes(261), 3, 39),
                new Paciente("Alfonso Bueno", base.plusMinutes(264), 6, 58),
                new Paciente("Consuelo Ríos", base.plusMinutes(267), 10, 92),
                new Paciente("Martín Segura", base.plusMinutes(270), 2, 13),
                new Paciente("Isabel Mendoza", base.plusMinutes(273), 7, 55),
                new Paciente("Leo Salazar", base.plusMinutes(276), 4, 20),
                new Paciente("Aitana Ponce", base.plusMinutes(279), 9, 74),
                new Paciente("Eduardo Escudero", base.plusMinutes(282), 1, 16),
                new Paciente("Leticia Barrios", base.plusMinutes(285), 5, 63),
                new Paciente("Pedro Contreras", base.plusMinutes(288), 8, 71),
                new Paciente("Débora Palacios", base.plusMinutes(291), 3, 45),
                new Paciente("Ramón Aranda", base.plusMinutes(294), 6, 69),
                new Paciente("Maite Zamora", base.plusMinutes(297), 10, 81)
        ));
    }
}
