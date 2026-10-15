package Practica1.ej2;



import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ej2 {
    static void main() throws InterruptedException {
        ColaTareas tareas = new ColaTareas();

        Thread h1 = new Thread(new Productor(tareas,"Productor" ));
        Thread h2 = new Thread(new Consumidor(tareas,"Consumidor - 1" ));
        Thread h3 = new Thread(new Consumidor(tareas,"Consumidor - 2"));

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();
    }
}

class ColaTareas {
    Integer cont = 0;

    Queue<Integer> cola = new ArrayBlockingQueue<>(3);

    public synchronized boolean producir(Integer num) throws InterruptedException {
        while (true) {
            if (cola.offer(num)) {
                notifyAll();
                return true;
            } else {
                wait();
            }
        }
    }

    public synchronized Integer consumir() throws InterruptedException {
        while (true) {
            try {
                Integer num = cola.poll();
                if (num != null) {
                    notifyAll();
                    cont++;
                    return num;
                }
            } catch (NoSuchElementException e) {
                wait();
            }
        }

    }
}

class Productor implements Runnable {
    private ColaTareas cola;
    private String nombre;

    public Productor(ColaTareas cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                boolean completado = true;
                while (completado) {
                    if (cola.producir(i)){
                        System.out.println("["+nombre+"] Tarea producida: "+i);
                        completado = false;
                    }
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumidor implements Runnable {
    private ColaTareas cola;
    private String nombre;

    public Consumidor(ColaTareas cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (true) {
                boolean completado = true;
                while (completado) {
                    Integer num = cola.consumir();
                    if (num != null){
                        System.out.println("["+nombre+"] Tarea consumida: "+num);
                        completado = false;
                    }
                }
                Thread.sleep(800);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}