package Ejercicios;

import java.util.*;

public class EjerciciosListas {
    static void main() {
        List<Integer> listaInt = new ArrayList<>(Arrays.asList(2,1,5,2,4,6,3,2,5));
        for (Integer i: sacarPares(listaInt)){
            System.out.print(String.valueOf(i));
        }
        System.out.println();

        List<String> listaStr = new ArrayList<>(Arrays.asList("Hola", "Hecproll", "largoooooooo", "A", "b"));

        // Forma 1
        System.out.println(masLargo(listaStr));

        // Forma 2
        Collections.sort(listaStr, new ordenarSegunTamano());
        System.out.println(listaStr.getFirst());

        // Pruebas
        Collections.sort(listaStr, new ordenarAlfabeticamente());
        System.out.println(listaStr);
    }

    static List<Integer> sacarPares(List<Integer> lista){
        return lista.stream().filter(a->a%2==0).toList();
    }

    // Forma 1
    static String masLargo(List<String> lista){
        return lista.stream().max(Comparator.comparing(String::length)).get();
    }
}

// Forma 2
class ordenarSegunTamano implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()>o2.length()?-1:1;
    }
}

// Pruebas
class ordenarAlfabeticamente implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
