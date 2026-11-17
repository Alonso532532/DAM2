package T1.Ejs2.Ej3;

import java.io.File;
import java.io.IOException;

public class Ej3 {
    static void main() {
        try {
            Process proceso = new ProcessBuilder("src/T1.Ejs2/Ej3/Script.bat")
                    .redirectOutput(new File("src/T1.Ejs2/Ej3/Salida.log"))
                    .redirectError(new File("src/T1.Ejs2/Ej3/Errores.log")).start();

            proceso.waitFor();

            System.out.println("Proceso terminado");

            System.out.println(proceso.exitValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
