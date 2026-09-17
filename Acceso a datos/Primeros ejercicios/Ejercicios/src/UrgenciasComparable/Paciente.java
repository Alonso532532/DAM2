package UrgenciasComparable;

import java.time.LocalDateTime;

public class Paciente implements Comparable<Paciente>{
    private String Nombre;
    private Integer gravedad;
    private LocalDateTime horaDeLegada;

    public Paciente(String nombre, Integer gravedad, LocalDateTime horaDeLegada) {
        Nombre = nombre;
        this.gravedad = gravedad;
        this.horaDeLegada = horaDeLegada;
    }

    public Paciente() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getGravedad() {
        return gravedad;
    }

    public void setGravedad(Integer gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDateTime getHoraDeLegada() {
        return horaDeLegada;
    }

    public void setHoraDeLegada(LocalDateTime horaDeLegada) {
        this.horaDeLegada = horaDeLegada;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "Nombre='" + Nombre + '\'' +
                ", gravedad=" + gravedad +
                ", horaDeLegada=" + horaDeLegada +
                '}';
    }

    @Override
    public int compareTo(Paciente o) {
        return this.getGravedad() == o.getGravedad() ? (this.getHoraDeLegada().isAfter(o.getHoraDeLegada()) ? 1 : -1) : o.getGravedad() - this.getGravedad();
    }
}
