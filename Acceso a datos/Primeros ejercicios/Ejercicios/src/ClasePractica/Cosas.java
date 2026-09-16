package ClasePractica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Cosas {
    static void main() {
        List<Integer> lista = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        System.out.println(calculaCuadrados(lista));

        Persona prueba = new Persona();

        System.out.println(prueba.edad);
        System.out.println(Persona.edadSt);
        Persona.edadSt=99;
        prueba.edad=99;
        System.out.println(prueba.edad);
        System.out.println(Persona.edadSt);
    }

    static List<Integer> calculaCuadrados(List<Integer> lista){
        // Un predicado tiene que devolver un booleano
        // Un consumer no devuelve nada, se usa para realizar acciónes que no necesitan una respuesta (sout)
        // Un function toma un argumento y devuelve un resultado
        // Un supplier no toma ningún argumento y devuelve un resultado

        //return lista.stream().filter(n->n%2==0).map(n->n*n).toList();

        // Estos elementos se pueden hacer a parte se puede hacer a parte
        Predicate<Integer> esPar = n->n%2==0;

        return lista.stream().filter(esPar).map(n->n*n).toList();
    }
}
