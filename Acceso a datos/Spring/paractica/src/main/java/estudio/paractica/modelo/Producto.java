package estudio.paractica.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
    double precio;
    long cant;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoAplicado")
    @Builder.Default
    List<Oferta> ofertasActuales = new ArrayList<>();

    public void addOferta(Oferta oferta) {
        ofertasActuales.add(oferta);
        oferta.setProductoAplicado(this);   // aquí se rellena la FK
    }

    public void removeOferta(Oferta oferta) {
        ofertasActuales.remove(oferta);
        oferta.setProductoAplicado(null);
    }
}
