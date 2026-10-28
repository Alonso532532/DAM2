package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.*;
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
    // Para evitar la creación de un id se pone aquí el nombre del campo que hace relación en el elemento padre
    @OneToOne(mappedBy = "coche")
    Persona persona;

    // =================== To string para evitar fallos en la relación bidireccional
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", persona=" + persona.getId() + " - " + persona.getDni() +
                '}';
    }
}
