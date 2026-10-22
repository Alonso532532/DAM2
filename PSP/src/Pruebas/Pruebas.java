package Pruebas;

import java.lang.Runnable;

public class Pruebas {
    static void main() {
        Cont count = new Cont();
        for (int i = 0; i < 10; i++) {
            Thread h1 = new Thread(new Hilo(count));
            h1.run();
        }
    }
}

class Hilo implements Runnable {

    Cont contador;

    public Hilo(Cont contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            contador.sumar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cont {
    Integer cont = 0;

    public synchronized void sumar() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(++cont);
    }


}

