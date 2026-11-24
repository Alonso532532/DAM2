package estudio.paractica.modelos;

import estudio.paractica.repositorios.ProductoRepositorio;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String nombre;

    @OneToOne(mappedBy = "oferta")
    Producto productoOfertado;

    double porcentaje;

}
