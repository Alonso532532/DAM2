package T1.Ejs2.ej4;

import java.io.File;
import java.io.IOException;

public class ej4 {
    static void main() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe");

        pb.redirectInput(new File("src/T1.Ejs2/ej4/comandos.txt"));

        pb.redirectOutput(new File("src/T1.Ejs2/ej4/Salida.log"));
        pb.redirectError(new File("src/T1.Ejs2/ej4/Errores.log"));

        pb.start();
    }
}
