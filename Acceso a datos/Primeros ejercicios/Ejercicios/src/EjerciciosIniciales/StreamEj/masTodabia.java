package EjerciciosIniciales.StreamEj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class masTodabia {
    public static void main(String[] args) {
        HashMap<String, Integer> palabras = new HashMap<>();
        try(BufferedReader leer = new BufferedReader( new FileReader("src/Ejercicios.StreamEj/DATA.csv"))){
            String linea;
            while ((linea = leer.readLine()) != null){
                Matcher matcher = Pattern.compile("[A-Z]{2}").matcher(linea);
                while (matcher.find()){
                    palabras.put(matcher.group(), palabras.get(matcher.group())!=null ? palabras.get(matcher.group())+1 : 1);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(palabras);
        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());
        lista.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(a->a.getValue()).forEach(System.out::println);

    }
}
