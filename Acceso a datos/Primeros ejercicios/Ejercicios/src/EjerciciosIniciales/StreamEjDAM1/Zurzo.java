package EjerciciosIniciales.StreamEjDAM1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Zurzo {
    public static void main(String[] args) {
        HashMap<Integer, Registro> regs = new HashMap<>();
        try (BufferedReader leer = new BufferedReader(new FileReader("src/Ejercicios.StreamEj/DATA.csv"))){
            String linea;
            Boolean primera = true;
            while((linea = leer.readLine())!=null){
                if (primera){
                    primera=false;
                }else{
                    String[] separado = linea.split(",");
                    regs.put(Integer.parseInt(separado[0]), new Registro(Integer.parseInt(separado[0]), separado[1], separado[2], Double.parseDouble(separado[3]), Double.parseDouble(separado[4]), separado[5], separado[6], separado[7], separado[8], LocalDateTime.parse(separado[9].replace(" ", "T"))));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        ArrayList<Map.Entry<Integer, Registro>> registros = new ArrayList<>(regs.entrySet());

        registros.stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Registro::getLatitud).reversed())).limit(10).forEach(System.out::println);

    }
}
