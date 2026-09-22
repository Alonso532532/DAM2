package EjerciciosStreams.Ej4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ej4 {
    static void main() {
        List<Producto> productos = new ArrayList<>();
        try (FileReader reader = new FileReader("src/EjerciciosStreams/Ej4/Datos.csv")){
            List<String> lineas = new ArrayList<>(reader.readAllLines());
            lineas.removeFirst();
            lineas.forEach(l->{
                List<String> atr = List.of(l.split(";"));
                productos.add(new Producto(atr.get(0), Double.parseDouble(atr.get(1)), atr.get(2)));
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        // Es lo mismo
        System.out.println(productos.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting())));
        Map<String, Long> porCat = productos.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        System.out.println(productos.stream().filter(a -> a.precio >= 10 && a.precio <= 20).toList());
    }
}
