package Ejercicios.StreamEj;

import java.time.LocalDateTime;

public class Registro {
    //id,first_name,last_name,latitude,longitude,domain,email,country,ip_address,last_login
    private int id;
    private String nombre;
    private String apellido;
    private double latitud;
    private double longitud;
    private String dominio;
    private String email;
    private String pais;
    private String direccion_ip;
    LocalDateTime last_login_date;


    public Registro(int id, String nombre, String apellido, double latitud, double longitud, String dominio, String email, String pais, String direccion_ip, LocalDateTime last_login_date) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dominio = dominio;
        this.email = email;
        this.pais = pais;
        this.direccion_ip = direccion_ip;
        this.last_login_date = last_login_date;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", dominio='" + dominio + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                ", direccion_ip='" + direccion_ip + '\'' +
                ", last_login_date=" + last_login_date +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDominio() {
        return dominio;
    }

    public String getEmail() {
        return email;
    }

    public String getPais() {
        return pais;
    }

    public String getDireccion_ip() {
        return direccion_ip;
    }

    public LocalDateTime getLast_login_date() {
        return last_login_date;
    }
}
