package Apuntes;

public class Producto implements Comparable<Producto>{
    String nombre;
    Double precio;
    String categoria;
    Double oferta;

    public Producto(String nombre, Double precio, String categoria, Double oferta) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.oferta = oferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getOferta() {
        return oferta;
    }

    public void setOferta(Double oferta) {
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "(Precio total="+(precio-precio*oferta)+") Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", oferta=" + oferta +
                '}';
    }

    // Comparable sirve para implementar este método
    // Aquí se compara el objeto actual con otro, si devuelve positivo
    // Si el precio con la oferta es mayor que el del otro será positivo y se pondrá después
    @Override
    public int compareTo(Producto o) {
        double dif = (this.precio-this.oferta*this.precio)-(o.precio-o.oferta*o.precio);
        if (dif>0){
            return 1;
        } else {
            return dif==0?0:-1;
        }
    }
}
