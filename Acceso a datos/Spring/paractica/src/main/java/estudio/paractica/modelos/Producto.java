package estudio.paractica.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String nombre;

    double precio;
    double precioTotal;

    @OneToOne
    @JoinColumn(name = "oferta_aplicada")
    Oferta oferta;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", precioTotal=" + precioTotal +
                ", oferta=" + (oferta == null ? "Sin oferta" : oferta.getNombre()) +
                '}';
    }
}
