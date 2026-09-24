package ClasePractica.Prueba;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class input {
    static void main() {
        try (FileInputStream cosa = new FileInputStream("src/ClasePractica/Prueba/cosa.txt");){
            byte[] bytes = cosa.readAllBytes();
            String cad = "";

            // Forma 1
            String texto = new String(bytes, StandardCharsets.UTF_8);

            // Forma 2
            for (byte a : bytes) {
                cad = cad.concat(String.valueOf((char) a));
            }

            System.out.println(texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
