package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String modelo;
    String matricula;
}
