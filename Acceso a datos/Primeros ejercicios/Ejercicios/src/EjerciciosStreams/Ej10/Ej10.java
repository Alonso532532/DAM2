package EjerciciosStreams.Ej10;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        lista.forEach(System.out::println);
    }
}
