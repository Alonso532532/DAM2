package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
// Mete muchos metodos (getter, setter...) no es aconsejable
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime time = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "order_id")
    Cliente cliente;
}
