package EjerciciosIniciales;

import java.util.*;

public class EjerciciosSets {
    static void main() {
        Set<String> frutas = Set.of("Hola", "AAAA", "CC");
        System.out.println(frutas);

        List<String> lista = new ArrayList<>(Arrays.asList("1","2","3","5","6","322","1","2","3","4","5","3","6","3","62","1","2","5"));
        HashMap<String, Integer> cant = new HashMap<>();

        lista.forEach(a->cant.put(a, cant.containsKey(a) ? cant.get(a)+1 : 1));

        cant.forEach((k, v)-> {
            if (v == 1) {
                System.out.println(k);
            }
        });
    }
}
