package Ejercicio1TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(123)) {

            while (true){
                try (
                    Socket cliente = socket.accept();
                    PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                    Scanner in = new Scanner(cliente.getInputStream());
                    ){

                    String mensage = in.nextLine();
                    System.out.println(mensage);

                    out.println(mensage+" - RECIVIDO ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
