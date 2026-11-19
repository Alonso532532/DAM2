package estudio.paractica.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "ofertasActuales", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    List<Producto> productosAplicados = new ArrayList<>();

}
