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
@ToString
public class Producto {
    @Id
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Builder.Default
    private Double precio = 0.0;

    @ManyToMany(mappedBy = "productos")
    @ToString.Exclude
    List<Pedido> pedidos = new ArrayList<>();

    @OneToOne
    Proveedor proveedor;
}
