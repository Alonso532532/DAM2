package EjercicioObjetos.UDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static DatagramSocket datagramSocket;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            datagramSocket = new DatagramSocket(5324);

            ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(streamOut);
            out.writeObject(new Datos("Conexion"));
            out.close();

            byte[] bytes = streamOut.toByteArray();
            DatagramPacket paqueteConexion = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 5325);
            datagramSocket.send(paqueteConexion);

            while (true){

                Datos datosResp = recivirDatos();

                System.out.println(datosResp.datos);
                while (datosResp.getTipo().equals("Opcion")) {

                    System.out.print("> ");
                    String resp = sc.nextLine();

                    bytes = resp.getBytes();
                    DatagramPacket paqueteOpcion = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 5325);
                    datagramSocket.send(paqueteOpcion);

                    if (resp.equals("0")) return;

                    datosResp = recivirDatos();

                    System.out.println(datosResp.datos);
                }

                if (datosResp.getTipo().equals("Cerrar")) break;

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static Datos recivirDatos(){
        byte[] bytes = new byte[1024];
        DatagramPacket paqueteResp = new DatagramPacket(bytes, bytes.length);
        try {

            datagramSocket.receive(paqueteResp);

            ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
            ObjectInputStream in = new ObjectInputStream(inStream);
            return (Datos) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
