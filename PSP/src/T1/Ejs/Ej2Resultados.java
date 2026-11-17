public class Ej2Resultados {
}
static void main(String[] args) {
    try {
        File log = new File("src/T1.Ejs/Script.bat");

        // Esto crea un proceso que tiene y ejecuta un comando que abre un archivo
        Process script = new ProcessBuilder("src/T1.Ejs/Script.bat").redirectInput(log).redirectOutput(log).redirectError(log).start();
    } catch (IOException e){
        e.printStackTrace();
    }
}