package EjerciciosArchivos.CopiarDesde;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopiarDesde {
    static void main() {
        Scanner sc = new Scanner(System.in);

        List<String> archivos = new ArrayList<>();

        while (true){
            System.out.print("Dame el nombre de un archivo\n0 - Salir >");
            String resp = sc.nextLine();

            if (resp.equals("0")) break;

            Path ruta = Path.of("src/EjerciciosArchivos/CopiarDesde/".concat(resp));

            if (Files.exists(ruta)){
                archivos.add(ruta.toString());
            } else System.out.println("El archivo no existe");
        }

        for (String archivo : archivos) {
            try (FileWriter escribir = new FileWriter("src/EjerciciosArchivos/CopiarDesde/Destino.txt", true)){
                Files.readAllLines(Path.of(archivo)).forEach(a->{
                    try {
                        escribir.write(a.concat("\n"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
