package LamdaInterfaz;

public class Operaciones {
    static void main() {
        Operar suma = (a, b) -> a+b;

        Operar resta = (a, b) -> a-b;

        OperarCon2 cosicas = (a, b, c) -> a+b+c;

        System.out.println(suma.ejecutar(1,5));
    }
}

interface Operar {
    double ejecutar(double a, double b);
}

interface OperarCon2 {
    double ejecutar(double a, double b, double c);
}
