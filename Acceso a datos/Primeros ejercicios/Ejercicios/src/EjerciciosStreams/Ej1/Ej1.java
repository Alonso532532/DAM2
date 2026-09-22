package EjerciciosStreams.Ej1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1 {
    static void main() {
        List<Producto> lista = new ArrayList<>(Arrays.asList(
                new Producto(1, "Portatil",       899.99, true,  'E'),
                new Producto(2, "Raton",           15.50, false, 'A'),
                new Producto(3, "Teclado mecanico", 79.90, true,  'A'),
                new Producto(4, "Monitor 24",    159.99, false, 'E'),
                new Producto(5, "Auriculares",      45.00, true,  'A'),
                new Producto(6, "Webcam HD",        29.95, false, 'E')
        ));

//        try (FileWriter escribir = new FileWriter("src/EjerciciosStreams/Ej1/productos.txt", false);){
//            for (Producto producto : lista) {
//                escribir.write(producto.toString());
//                System.out.println(producto);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        try (RandomAccessFile escribir = new RandomAccessFile("src/EjerciciosStreams/Ej1/productos.txt", "rw");){
            for (Producto producto : lista) {
                escribir.write(producto.toString().concat("\n").getBytes());
            }
            escribir.seek(0);
            String linea;
            while ((linea = escribir.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
