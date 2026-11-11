package org.example.parte2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class TareaMaxYMin extends RecursiveTask<List<Registro>> {
    List<Registro> regs;

    public TareaMaxYMin(List<Registro> regs) {
        this.regs = regs;
    }

    @Override
    public List<Registro> compute() {
        int tamano = regs.size();
        if (tamano > 200) {
            TareaMaxYMin div1 = new TareaMaxYMin(regs.subList(0, tamano / 2));
            TareaMaxYMin div2 = new TareaMaxYMin(regs.subList(tamano / 2, tamano));

            div1.fork();
            //div2.fork(); // Ejecuto el div2 en este hilo en vez de usar otro nuevo

            List<Registro> rdiv2 = div2.compute();
            List<Registro> rdiv1 = div1.join();

            return Arrays.asList(
                    masAlta(rdiv1.get(0), rdiv2.get(0)),
                    masBaja(rdiv1.get(1), rdiv2.get(1)));
        } else {
            Registro max = regs.stream()
                    .filter(r -> r.getTmax() != null)      // ignoro registros sin dato
                    .max(Comparator.comparing(Registro::getTmax))
                    .orElse(null);                         // null si no hay ninguno
            Registro min = regs.stream()
                    .filter(r -> r.getTmin() != null)
                    .min(Comparator.comparing(Registro::getTmin))
                    .orElse(null);
            return Arrays.asList(max, min);
        }
    }

    private static Registro masAlta(Registro a, Registro b) {
        if (a == null) return b;
        if (b == null) return a;
        return a.getTmax() >= b.getTmax() ? a : b;
    }

    private static Registro masBaja(Registro a, Registro b) {
        if (a == null) return b;
        if (b == null) return a;
        return a.getTmin() <= b.getTmin() ? a : b;
    }
}
