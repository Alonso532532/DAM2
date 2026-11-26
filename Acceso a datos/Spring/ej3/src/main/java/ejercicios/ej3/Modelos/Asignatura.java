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
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    @ManyToMany
    @Builder.Default
    @JoinTable(
            name = "alumnos_asignaturas",
            joinColumns = @JoinColumn(name = "asignatura_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    List<Estudiante> estudiantes = new ArrayList<>();
}
