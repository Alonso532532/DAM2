package EjerciciosStreams.Ej6;


import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String dni;
    private List<Coche> coches;

    public Persona(String nombre, String dni, List<Coche> coches) {
        this.nombre = nombre;
        this.dni = dni;
        this.coches = coches;
    }

    // Constructor alternativo, útil si aún no tiene coches asignados
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.coches = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', dni='" + dni + "', coches=" + coches + "}";
    }
}

