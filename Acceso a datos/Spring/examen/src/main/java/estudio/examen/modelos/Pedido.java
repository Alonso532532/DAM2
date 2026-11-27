package estudio.examen.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precioTotal;

    @ManyToOne
    Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pedidos_clientes",
            joinColumns = @JoinColumn(name = "pedidos"),
            inverseJoinColumns = @JoinColumn(name = "productos")
    )
    List<Producto> productos = new ArrayList<>();

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", precioTotal=" + precioTotal +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}
