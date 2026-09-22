package EjerciciosStreams.Ej2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej2 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Que quieres reemplazar\n>");
        String reemplazar = sc.nextLine();
        System.out.print("Por que lo quieres reemplazar\n>");
        String reemplazo = sc.nextLine();

        try (
            BufferedReader reader = new BufferedReader(new FileReader("src/EjerciciosStreams/Ej2/PorReemplazar.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/EjerciciosStreams/Ej2/Reemplazado.txt",false))
        ){
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea.replaceAll(reemplazar, reemplazo).concat("\n"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
