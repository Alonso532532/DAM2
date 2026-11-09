package org.iesch.ad.demoCarga.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    // Para que sea eager
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos;

}
