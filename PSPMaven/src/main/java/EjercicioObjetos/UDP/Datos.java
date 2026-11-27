package EjercicioObjetos.UDP;

import java.io.Serializable;

public class Datos implements Serializable {
    String tipo;
    String datos;

    public Datos(String tipo, String datos) {
        this.tipo = tipo;
        this.datos = datos;
    }

    public Datos(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "tipo='" + tipo + '\'' +
                ", datos='" + datos + '\'' +
                '}';
    }
}
