package Apuntes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    static void main() {
        List<Producto> lista = new ArrayList<>();
        inicializarLista(lista);

        System.out.println("\n\n==== Valores ====\n\n");
        System.out.println("---- COUNT ----");
        System.out.println(lista.stream().count());

        System.out.println("---- MAX/MIN ----");
        System.out.println(lista.stream().max(Comparator.comparing(Producto::getPrecio)));

        // Hago que solo me muestre 2 decimales
        System.out.println("---- AVG ----");
        System.out.println(Double.valueOf(Math.round(lista.stream().mapToDouble(Producto::getPrecio).average().getAsDouble()*100))/100);

        System.out.println("\n\n==== Valores con groupingBy ==== (Si se quiere de un tipo en especifico se hace con filter)\n\n");
        System.out.println("---- COUNT ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting())));

        System.out.println("---- MAX/MIN ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.maxBy(Comparator.comparing(Producto::getPrecio)))));

        System.out.println("---- AVG ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.averagingDouble(Producto::getPrecio))));

        System.out.println("\n\n==== Ordenar ====\n\n");
        System.out.println("---- Normal ---- (Por ptecio)");
        lista.stream().sorted(Comparator.comparing(Producto::getPrecio)).forEach(System.out::println);

        System.out.println("---- Con comparable ---- (Por precio total)");
        lista.stream().sorted().forEach(System.out::println);

        System.out.println("---- Con comparator ---- (Por oferta y si son iguales por nombre)");
        lista.stream().sorted(new comparadorPorOferta()).forEach(System.out::println);





    }

    static void inicializarLista(List<Producto> productos){
        productos.add(new Producto("Camiseta básica", 12.99, "Ropa", 0.10));
        productos.add(new Producto("Pantalón vaquero", 34.50, "Ropa", 0.0));
        productos.add(new Producto("Zapatillas running", 59.99, "Calzado", 0.20));
        productos.add(new Producto("Chaqueta impermeable", 79.90, "Ropa", 0.15));
        productos.add(new Producto("Auriculares bluetooth", 45.00, "Electrónica", 0.05));
        productos.add(new Producto("Teclado mecánico", 89.99, "Electrónica", 0.0));
        productos.add(new Producto("Ratón inalámbrico", 19.99, "Electrónica", 0.10));
        productos.add(new Producto("Monitor 24 pulgadas", 149.99, "Electrónica", 0.25));
        productos.add(new Producto("Silla de oficina", 120.00, "Muebles", 0.0));
        productos.add(new Producto("Mesa de escritorio", 95.50, "Muebles", 0.10));
        productos.add(new Producto("Lámpara LED", 22.30, "Muebles", 0.0));
        productos.add(new Producto("Mochila urbana", 39.99, "Accesorios", 0.15));
        productos.add(new Producto("Reloj deportivo", 65.00, "Accesorios", 0.0));
        productos.add(new Producto("Gafas de sol", 25.00, "Accesorios", 0.30));
        productos.add(new Producto("Botella térmica", 15.99, "Accesorios", 0.0));
        productos.add(new Producto("Balón de fútbol", 18.50, "Deporte", 0.0));
        productos.add(new Producto("Mancuernas 5kg", 29.99, "Deporte", 0.10));
        productos.add(new Producto("Esterilla de yoga", 14.99, "Deporte", 0.0));
        productos.add(new Producto("Bicicleta estática", 199.99, "Deporte", 0.20));
        productos.add(new Producto("Cuerda para saltar", 8.99, "Deporte", 0.0));
    }
}

class comparadorPorOferta implements Comparator<Producto>{
    @Override
    public int compare(Producto o1, Producto o2) {
        double dif = o1.oferta-o2.oferta;
        if (dif!=0){
            return dif>0?1:-1;
        } else {
            return o1.getNombre().compareTo(o2.nombre);
        }
    }
}