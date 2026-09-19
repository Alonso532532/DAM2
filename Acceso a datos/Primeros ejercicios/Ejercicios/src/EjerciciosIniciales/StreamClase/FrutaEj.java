package EjerciciosIniciales.StreamClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrutaEj {
    static void main() {
        List<Fruta> lista = new ArrayList<>(Arrays.asList(
                new Fruta("Manzana", 12.90),
                new Fruta("Pera", 11.90),
                new Fruta("Platano", 12.90)
        ));

        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,5,3));
        System.out.println("Ej 1");
        lista.stream().map(Fruta::getNombre).forEach(System.out::println);
        System.out.println("Ej 2");
        lista.stream().map(Fruta::getPrecio).distinct().forEach(System.out::println);
        System.out.println("Ej 3");
        System.out.println(numeros.stream().map(a -> a * a).reduce(0, Integer::sum));
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