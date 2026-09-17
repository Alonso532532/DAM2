package UrgenciasComparator;

import java.util.Comparator;

public class ComparadorPacientes implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
//        if (o1.getGravedad() == o2.getGravedad()){
//            return o1.getHoraDeLegada().isBefore(o2.getHoraDeLegada()) ? 1 : -1;
//        } else {
//            return o1.getGravedad() - o2.getGravedad();
//        }
        // Reducido
        return o1.getGravedad() == o2.getGravedad() ? (o1.getHoraDeLegada().isAfter(o2.getHoraDeLegada()) ? 1 : -1) : o2.getGravedad() - o1.getGravedad();

    }
}
