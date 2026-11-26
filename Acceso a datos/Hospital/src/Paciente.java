import java.time.LocalDateTime;
import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private LocalDateTime horaDeLlegada;
    private Integer gravedad;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(LocalDateTime horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public Integer getGravedad() {
        return gravedad;
    }

    public void setGravedad(Integer gravedad) {
        this.gravedad = gravedad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Paciente(String nombre, LocalDateTime horaDeLlegada, Integer gravedad, Integer edad) {
        this.nombre = nombre;
        this.horaDeLlegada = horaDeLlegada;
        this.gravedad = gravedad;
        this.edad = edad;
    }


    @Override
    public int compareTo(Paciente o) {
        if (o.gravedad == gravedad){
            return horaDeLlegada.compareTo(o.getHoraDeLlegada());
        } else {
            return o.getGravedad().compareTo(gravedad);
        }
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", horaDeLlegada=" + horaDeLlegada +
                ", gravedad=" + gravedad +
                ", edad=" + edad +
                '}';
    }
}
