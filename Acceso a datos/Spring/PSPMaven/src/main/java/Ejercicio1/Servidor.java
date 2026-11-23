package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Servidor{

    public static void main(String[] args) {
        try (DatagramSocket socketUDP = new DatagramSocket(5324)) {

            // Hago el buffer que se asigna al paquete recibirá el paquete del cliente
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);


            while (true) {
                // Espero a que me llegue el paquete
                socketUDP.receive(packet);

                String info = new String(packet.getData()).trim();

                if (info.equals("0")) break;

                switch (info) {
                    case "1":

                        List<Path> archivos = new ArrayList<>();
                        // Guardo las rutas en una lista
                        Path dir = Path.of("src/main/java/Ejercicio1/Archivos");
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                            StringBuilder string = new StringBuilder();

                            string.append("<===== Archivos =====>\n");
                            for (Path path: stream) {
                                string.append(path.getFileName()+"\n");
                            }
                            string.append("<====================>\n\n");

                            byte[] mensaje = string.toString().getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);

                        } catch (IOException | DirectoryIteratorException x) {
                            System.err.println(x);
                        }

                        break;
                    case "2":
                        socketUDP.receive(packet);
                        String archivo = new String(packet.getData()).trim();

                        try {

                            String contenido =  Files.readString(Path.of("src/main/java/Ejercicio1/Archivos/"+archivo));

                            StringBuilder string = new StringBuilder();

                            string.append("<===== Contenido =====>\n");
                            string.append(contenido+"\n");
                            string.append("<=====================>\n\n");

                            byte[] mensaje = string.toString().getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);

                        }catch (IOException e){
                            byte[] mensaje = "Atchivo no encontrado".getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);
                        }
                        break;
                    default:
                        System.out.println("Opción inválida"+info);
                }
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
