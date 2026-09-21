package EjerciciosIniciales.StreamClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FrutaEj {
    static void main() {
        List<Fruta> lista = new ArrayList<>(Arrays.asList(
                new Fruta("Manzana", 2.00),
                new Fruta("Manzana", 1.00),
                new Fruta("Platano", 1.00),
                new Fruta("Platano", 2.00),
                new Fruta("Platano", 4.00)
        ));

        System.out.println(lista.stream().filter(a -> Objects.equals(a.nombre, "Manzana")).map(a -> a.precio).reduce(Double::sum).get());

        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,5,3));
        System.out.println("Ej 1");
        lista.stream().map(Fruta::getNombre).forEach(System.out::println);
        System.out.println("Ej 2");
        lista.stream().map(Fruta::getPrecio).distinct().forEach(System.out::println);
        System.out.println("Ej 3");
        // Con reduce
        System.out.println(numeros.stream().map(a -> a * a).reduce(0, Integer::sum));
        // Con collect
        System.out.println(numeros.stream().collect(Collectors.summingInt(a->a*a)));
        // Con map to int
        System.out.println(numeros.stream().mapToInt(a->a*a).sum());
    }
}

class Fruta {
    String nombre;
    Double precio;

    public Fruta(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}