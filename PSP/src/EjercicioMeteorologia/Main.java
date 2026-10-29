package EjercicioMeteorologia;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static void main() {
        Path dir = Path.of("src/EjercicioMeteorologia/registros");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
        {
            for (Path path: stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {

        // IOException can never be thrown by the iteration.
        // In this snippet, it can only be thrown by new DirectoryStream.

            System.err.println(x);
        }
    }
}
