package org.example.parte2;

public class Registro {
    String fecha;
    String nombre;
    String provincia;
    Float tmin;
    String horatmin;
    Float tmax;
    String horatmax;
    String indicativo;

    // Saco el año y més para poder agrupar por estos
    String mes;

    public void calcularFecha(){
         mes = fecha.substring(5, 7);
    }

    public Registro(String fecha, String nombre, String provincia, Float tmin, String horatmin, Float tmax, String horatmax, String indicativo) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.provincia = provincia;
        this.tmin = tmin;
        this.horatmin = horatmin;
        this.tmax = tmax;
        this.horatmax = horatmax;
        this.indicativo = indicativo;
        calcularFecha();
    }

    public Registro() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Float getTmin() {
        return tmin;
    }

    public void setTmin(Float tmin) {
        this.tmin = tmin;
    }

    public String getHoratmin() {
        return horatmin;
    }

    public void setHoratmin(String horatmin) {
        this.horatmin = horatmin;
    }

    public Float getTmax() {
        return tmax;
    }

    public void setTmax(Float tmax) {
        this.tmax = tmax;
    }

    public String getHoratmax() {
        return horatmax;
    }

    public void setHoratmax(String horatmax) {
        this.horatmax = horatmax;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    @Override
    public String toString() {
        return "Fecha - " + fecha +
                " | Localidad - " + nombre +
                " | Provincia - " + provincia +
                " | Temperatura maxima - " + tmax +
                " | Temperatura minima - " + tmin +
                " | horatmin - " + horatmin +
                " | horatmax - " + horatmax +
                " | mesYAno - " + mes +
                " | Indicativo - " + indicativo;
    }
}
