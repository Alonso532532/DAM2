package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
// Mete muchos metodos (getter, setter...) no es aconsejable
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    // Bidireccional
    @OneToMany(mappedBy = "cliente")
    // Unidireccional
    // Con esto le estoy diciendo que va a se un uno a muchos (un cliente muchos pedidos), y "@JoinColumn" le especifica como se le va a llamar en la otra tabla
//    @OneToMany
//    @JoinColumn(name = "order_id")
    List<Orden> listaOrdenes;

}
