package EjercicioObjetos.UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Servidor {

    static DatagramSocket datagramSocket;

    public static void main(String[] args) {

        List<Datos> datos = new ArrayList<>(Arrays.asList(new Datos("Base", "Generado automaticamente")));
        while (true){

            try {

                datagramSocket = new DatagramSocket(5325);

                // Primera conexión

                byte[] bytes = new byte[1024];
                DatagramPacket paqueteSaludo = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(paqueteSaludo);

                ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
                ObjectInputStream in = new ObjectInputStream(inStream);
                Datos datosSaludo = (Datos) in.readObject();
                in.close();

                // Si el primer mensaje no es "Conexión" la rechazo y busco otras

                if (datosSaludo.getTipo().equals("Conexion")) {

                    while (true) {
                        // Envío el menú

                        enviarDatos(new Datos("Opcion", "<===== MENU =====>\n1 - Consultar datos\n2 - Añadir dato\n3 - Borrar\n0 - Salir\n<===========>"));

                        // Espero la respuesta del menú

                        String resp = recivirOp();

                        System.out.println("Opción: "+resp);

                        String todosString;

                        switch (resp){
                            case "1":

                                todosString = "";

                                for (Datos dato : datos) {
                                    todosString = todosString.concat("Tipo: "+dato.tipo+" | Contenido: "+dato.datos+"\n");
                                }

                                enviarDatos(new Datos("Resumen datos", "\n"+todosString));

                            break;
                            case "2":

                                enviarDatos(new Datos("Opcion", "< Establece un tipo > "));

                                String tipo = recivirOp();

                                enviarDatos(new Datos("Opcion", "< Escribe un texto >"));

                                String datoTexto = recivirOp();

                                Datos datoNuevo = new Datos(tipo, datoTexto);
                                datos.add(datoNuevo);

                                enviarDatos(new Datos("Añadido", "Dato: "+datoNuevo+" añadido con éxito"));
                                break;
                            case "3":
                                todosString = "";

                                for (int i = 0; i < datos.size(); i++) {
                                    todosString = todosString.concat( (i+1)+") - Tipo: "+datos.get(i).tipo+" | Contenido: "+datos.get(i).datos+"\n");
                                }

                                enviarDatos(new Datos("Opcion", "¿Que elemento?\n"+todosString));

                                String index = recivirOp();

                                try {

                                    Datos datoEliminado = datos.remove(Integer.parseInt(index)-1);
                                    enviarDatos(new Datos("Eliminado", "\nDato: "+datoEliminado+" eliminado con éxito\n"));

                                }catch (IndexOutOfBoundsException e){
                                    enviarDatos(new Datos("Error", "\nOpción ["+index+"] inválida\n"));
                                }


                                break;
                            default:
                                enviarDatos(new Datos("Error", "Opción ["+resp+"] inválida"));
                        }
                        if (resp.equals("0")) {
                            datagramSocket.close();
                            break;
                        }
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }

    static String recivirOp(){

        byte[] bytes = new byte[1024];
        DatagramPacket paquete = new DatagramPacket(bytes, bytes.length);

        try {
            datagramSocket.receive(paquete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new String(paquete.getData()).trim();

    }

    static void enviarDatos(Datos dato){

        ByteArrayOutputStream streamOut = new ByteArrayOutputStream();

        try {

            ObjectOutputStream out = new ObjectOutputStream(streamOut);
            out.writeObject(dato);
            out.close();

            byte[] bytes = streamOut.toByteArray();
            DatagramPacket paqueteMenu = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 5324);
            datagramSocket.send(paqueteMenu);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
