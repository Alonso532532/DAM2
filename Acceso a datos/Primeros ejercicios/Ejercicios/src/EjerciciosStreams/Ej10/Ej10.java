package EjerciciosStreams.Ej10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Ej10 {
    static void main() {
        List<Producto> lista = new ArrayList<>();

        try (FileReader leer = new FileReader("src/EjerciciosStreams/Ej10/products.csv")){
            List<String> lineas = new ArrayList<>(leer.readAllLines());
            lineas.removeFirst();
            lineas.forEach(a->{
                List<String> reg = new ArrayList<>(Arrays.asList(a.split(",")));
                lista.add(new Producto(
                        Integer.parseInt(reg.get(0)),
                        reg.get(1),
                        Integer.parseInt(reg.get(2)),
                        Integer.parseInt(reg.get(3)),
                        reg.get(4),
                        Double.parseDouble(reg.get(5)),
                        Integer.parseInt(reg.get(6)),
                        Integer.parseInt(reg.get(7)),
                        Integer.parseInt(reg.get(8)),
                        !reg.get(9).equals("0")
                ));
        });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- 1 -----");
        lista.forEach(System.out::println);


        System.out.println("----- 2 -----");
        lista.stream().map(Producto::getProductName).forEach(System.out::println);

        System.out.println("----- 3 -----");
        lista.stream().filter(a->a.getUnitsInStock()<10).map(Producto::getProductName).forEach(System.out::println);

        System.out.println("----- 4 -----");
        lista.stream().filter(a->a.getUnitsInStock()<10).sorted(Comparator.comparing(Producto::getUnitsInStock)).map(Producto::getProductName).forEach(System.out::println);

        System.out.println("----- 5 -----");
        lista.stream().filter(a->a.getUnitsInStock()<10).sorted(Comparator.comparing(Producto::getUnitsInStock)).map(Producto::getProductName).toList().reversed().forEach(System.out::println);


        System.out.println("----- 6 -----");
        lista.stream().filter(a->a.getUnitsInStock()>10).sorted(new Comparador6()).forEach(System.out::println);

        System.out.println("----- 7 -----");
        lista.stream().filter(a->a.getUnitsInStock()>10).sorted(new Comparador7()).forEach(System.out::println);

        System.out.println("----- 8 -----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getSupplierID, Collectors.counting())));
        // Map<Integer, Long> porProv = lista.stream().collect(Collectors.groupingBy(Producto::getSupplierID, Collectors.counting()));

        System.out.println("----- 9 -----");
        lista.stream().collect(Collectors.groupingBy(Producto::getUnitsInStock, Collectors.summingDouble(Producto::getUnitPrice))).forEach((a,b)->{
            if (b>100){
                System.out.println(a+" - "+b);
            }
        });

        System.out.println("----- 10 -----");
        System.out.println(Math.round(lista.stream().mapToInt(Producto::getUnitsInStock).average().getAsDouble()));

        System.out.println("----- 11 -----");
        System.out.println(lista.stream().max(Comparator.comparing(Producto::getUnitPrice)));

        System.out.println("----- 12 -----");
        lista.stream().limit(50).forEach(System.out::println);
    }
}

class Comparador6 implements Comparator<Producto>{
    @Override
    public int compare(Producto o1, Producto o2) {
        if (o1.getUnitsInStock()!= o2.getUnitsInStock()){
            return o2.getUnitsInStock() - o1.getUnitsInStock();
        }
        return o1.getProductName().compareTo(o2.getProductName());
    }
}

class Comparador7 implements Comparator<Producto>{
    @Override
    public int compare(Producto o1, Producto o2) {
        if (o1.getUnitsInStock()!= o2.getUnitsInStock()){
            return o1.getUnitsInStock() - o2.getUnitsInStock();
        }
        return o2.getProductName().compareTo(o1.getProductName());
    }
}
