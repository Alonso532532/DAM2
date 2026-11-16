package estudio.paractica.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
    double porcentaje;
    LocalDateTime inicio;
    LocalDateTime fin;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    @ToString.Exclude
    Producto productoAplicado;
}
