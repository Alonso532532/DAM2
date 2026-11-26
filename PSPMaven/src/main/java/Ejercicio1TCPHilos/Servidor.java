package Ejercicio1TCPHilos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(5324)) {

            while (true){
                new Thread(new Conexion(socket.accept())).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class Conexion implements Runnable{
    Socket cliente;

    public Conexion(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("Conexión empezada"+cliente.toString());
        try (
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                Scanner in = new Scanner(cliente.getInputStream());
        ){

            String respuesta = "";
            while (!respuesta.equals("0")) {
                out.println(
                        "<" + "=".repeat(10) + ">" + "\n" +
                                "0 - Salir\n" +
                                "1 - Mostrar archivos\n" +
                                "2 - Leer archivo"
                );
                out.println("0");

                respuesta = in.nextLine();
                if (respuesta.equals("0")) break;

                StringBuilder string = new StringBuilder();

                switch (respuesta){
                    case "1":

                        Path dir = Path.of("src/main/java/Ejercicio1UDP/Archivos");
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

                            string.append("<===== Archivos =====>\n");
                            for (Path path : stream) {
                                string.append(path.getFileName() + "\n");
                            }
                            string.append("<====================>");

                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        out.println(string.toString());

                        break;
                    case "2":
                        out.println("Nombre del archivo");
                        out.println("0");

                        String archivo = in.nextLine();

                        try {

                            String contenido =  Files.readString(Path.of("src/main/java/Ejercicio1TCP/Archivos/"+archivo));

                            string = new StringBuilder();

                            string.append("<===== Contenido =====>\n");
                            string.append(contenido+"\n");
                            string.append("<=====================>");

                            out.println(string);

                        }catch (IOException e){
                            out.println("Opción inválida");
                        }


                        break;
                    default:
                        out.println("Opción inválida");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fin de conexión"+cliente.toString());
    }
}