package Ejs2;

import java.io.File;
import java.io.IOException;

public class Ej2 {
    static void main() {
        try {

            File log = new File("src/Ejs2/Salida.txt");
            Process proceso = new ProcessBuilder("src/Ejs2/Script.bat").redirectOutput(log).start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
