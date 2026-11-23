package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        try (DatagramSocket datagramSocket = new DatagramSocket(5325)) {
            while (true) {

                System.out.println("<"+"=".repeat(10)+">");
                System.out.println("0 - Salir");
                System.out.println("1 - Mostrar archivos");
                System.out.println("2 - Leer archivo");
                System.out.print("> ");
                op = sc.nextLine();

                // Hago el mensaje
                byte[] mensaje = op.getBytes();

                // Construyo el paquete con la ip y el puerto del server además del paquete a enviar y lo envío mediante el socket que tiene un puerto temporal
                DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5324);
                datagramSocket.send(paquete);

                if (op.equals("0")) break;

                switch (op){
                    case "1":
                        byte[] buffer = new byte[1024];
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        datagramSocket.receive(packet);

                        String resp = new String(packet.getData()).trim();
                        System.out.println(resp);
                        break;
                    case "2":
                        System.out.println("¿Que archivo?");
                        System.out.print("> ");
                        op = sc.nextLine();

                        mensaje = op.getBytes();
                        paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5324);

                        datagramSocket.send(paquete);

                        byte[] buffer2 = new byte[1024];
                        DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length);
                        datagramSocket.receive(packet2);

                        String resp2 = new String(packet2.getData()).trim();
                        System.out.println(resp2);
                        break;
                }

                Thread.sleep(100);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
