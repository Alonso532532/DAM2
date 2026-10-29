package Estudio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasico {

    static void main() {
        Partida partida = new Partida();
        for (int i = 0; i < 2; i++) {
            new Thread(new DadoEquipo1(partida)).start();
        }
    }

}

class DadoEquipo1 implements Runnable {
    ReentrantLock lock;
    Boolean terminar = false;
    Partida partida;

    public DadoEquipo1(Partida partida) {
        this.partida = partida;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

    }
}

class Partida {
    Integer contEquipo1 = 0;
    Integer contEquipo2 = 0;

    ReentrantLock lock = new ReentrantLock();


    List<DadoEquipo1> equipo1 = new ArrayList<>();
    List<DadoEquipo1> equipo2 = new ArrayList<>();



    synchronized void tirarDadoE1(Object object){
        lock.tryLock();
        Integer dado = new Random().nextInt(1,7);
        System.out.println("Equipo 1 - ["+dado+"]");
        if (dado == 6){
            System.out.println("Ronda para el equipo 1");
            contEquipo1++;
            imprimirGrafico(contEquipo1);
            imprimirGrafico(contEquipo2);
            lock.lock();
        }
    }

    void imprimirGrafico(Integer victorias){
        StringBuilder cad = new StringBuilder("[");

        for (int i = 0; i < 3; i++) {
            if (i<victorias){
                cad.append("O");
            }else {
                cad.append("X");
            }
        }
        System.out.println(cad.append("]").toString());
    }
}