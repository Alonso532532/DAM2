package ClasePractica;

import java.util.*;

public class Lamda {
    // Interfaz con lamda
    public interface Saludo {
        void saludar(String nombre);
    }

    static void main() {
        // Interfaz con lamda
        Saludo saludo = n -> System.out.println("Hola "+n);

        saludo.saludar("Alons");

        //Ordenar por algo que no es natural
        List<String> lista = new ArrayList<>(Arrays.asList("Perro", "Gato", "Hecprooll"));

        //Ordena por orden natural
        //Collections.sort(lista);

        //Ordena por longitud corto
        //Collections.sort(lista, Comparator.comparing(String::length));

        //Con lamda
        //Collections.sort(lista, (s1, s2) -> s1.length() - s2.length());

        //con clase comparator
        Collections.sort(lista, new ComparadorDeCadenas());

        System.out.println(lista);
    }
}

class ComparadorDeCadenas implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

