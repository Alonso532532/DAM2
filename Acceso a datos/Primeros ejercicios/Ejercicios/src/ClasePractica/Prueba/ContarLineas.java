package ClasePractica.Prueba;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContarLineas {
    static void main() {
        try (FileReader reader = new FileReader("Primeros ejercicios/Ejercicios/src/ClasePractica/Prueba/cosa.txt")) {
            System.out.println(reader.readAllLines().size());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
