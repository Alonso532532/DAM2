package estudio.paractica.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinTable(
            name = "ofertas_producto",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "oferta_id")
    )
    List<Oferta> ofertasActuales = new ArrayList<>();

    public void addOferta(Oferta oferta) {
        ofertasActuales.add(oferta);
        oferta.getProductosAplicados().add(this);   // aquí se rellena la FK
    }

    public void removeOferta(Oferta oferta) {
        ofertasActuales.remove(oferta);
        oferta.getProductosAplicados().remove(this);
    }


}
