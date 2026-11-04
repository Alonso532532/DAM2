package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    // El cascade no solo es para eliminar, también para crear
    // "cursos" es del atributo de los cursos de la clase Student
    // El cascade all no es recomendable ponerlo en ambos sitios para que no se lie,
    // en este caso se pone Persist y Merge
    // Persist:
    //  Guarda la clase al guardar el padre
    // Merge:
    //  Guardar al actualizar
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cursos")
    Set<Student> estudiantes = new HashSet<>();

}
























// Iker lozano romero