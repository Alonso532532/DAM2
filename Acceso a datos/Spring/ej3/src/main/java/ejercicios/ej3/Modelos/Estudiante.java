package ejercicios.ej3.Modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    String email;

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    List<Asignatura> asignaturas = new ArrayList<>();
}
