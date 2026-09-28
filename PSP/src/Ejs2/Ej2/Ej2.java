package Ejs2.Ej2;

import java.io.File;
import java.io.IOException;

public class Ej2 {
    static void main() {
        try {

            File log = new File("src/Ejs2/Ej2/Salida.txt");
            Process proceso = new ProcessBuilder("src/Ejs2/Ej2/Script.bat").redirectOutput(log).start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
