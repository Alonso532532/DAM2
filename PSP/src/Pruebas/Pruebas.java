package Pruebas;

import java.lang.Runnable;

public class Pruebas {
    static void main() {
        Cont count = new Cont();
        for (int i = 0; i < 10; i++) {
            Thread h;
            if (i<5) {
                h = new Thread(new Hilo(count, 1));
            } else {
                h = new Thread(new Hilo(count, -1));
            }
            h.run();
        }
    }
}

class Hilo implements Runnable {

    Cont contador;
    Integer suma;

    public Hilo(Cont contador, Integer suma) {
        this.contador = contador;
        this.suma = suma;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(1000);
                if (suma>0){
                    contador.sumar();
                } else {
                    contador.restar();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cont {
    Integer cont = 10;

    public synchronized void sumar() throws InterruptedException {
        System.out.println(" ++++++++++ SUMANDO ++++++++++ ");
        System.out.println(++cont);
        System.out.println(" ++++++++++ SUMA TERMINADA ++++++++++ ");
    }

    public synchronized void restar() throws InterruptedException {
        System.out.println(" ---------- RESTANDO ---------- ");
        System.out.println(--cont);
        System.out.println(" ---------- RESTA TERMINADA ---------- ");
    }
}

