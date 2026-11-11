package org.example.parte2;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class TareaDatosTeruel extends RecursiveTask<DatosTeruel> {
    List<Registro> regs;

    public TareaDatosTeruel(List<Registro> regs) {
        this.regs = regs;
    }

    @Override
    protected DatosTeruel compute() {
        int tamano = regs.size();
        if (tamano > 200) {
            TareaDatosTeruel div1 = new TareaDatosTeruel(regs.subList(0, tamano / 2));
            TareaDatosTeruel div2 = new TareaDatosTeruel(regs.subList(tamano / 2, tamano));

            div1.fork();
            //div2.fork(); // Ejecuto el div2 en este hilo en vez de usar otro nuevo

            DatosTeruel rdiv2 = div2.compute();
            DatosTeruel rdiv1 = div1.join();

            rdiv1.calcularAvgMax(rdiv2.avgTMax);
            rdiv1.calcularAvgMin(rdiv2.avgTMin);
            rdiv1.calcularMaxMax(rdiv2.tMaxMax);
            rdiv1.calcularMinMax(rdiv2.tMinMax);
            rdiv1.calcularMaxMin(rdiv2.tMaxMin);
            rdiv1.calcularMinMin(rdiv2.tMinMin);

            return rdiv1;
        } else {
            DatosTeruel datosTeruel = new DatosTeruel();

            datosTeruel.tMaxMax = regs.stream().max(Comparator.comparing(Registro::getTmax)).get().tmax;
            datosTeruel.tMinMax = regs.stream().max(Comparator.comparing(Registro::getTmin)).get().tmin;
            datosTeruel.tMaxMin = regs.stream().min(Comparator.comparing(Registro::getTmax)).get().tmax;
            datosTeruel.tMinMin = regs.stream().min(Comparator.comparing(Registro::getTmin)).get().tmin;
            datosTeruel.avgTMax = (float) regs.stream().mapToDouble(a-> a.tmax).average().getAsDouble();
            datosTeruel.avgTMin = (float) regs.stream().mapToDouble(a-> a.tmax).average().getAsDouble();

            return datosTeruel;
        }
    }
}
