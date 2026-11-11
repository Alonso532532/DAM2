package alonso.ejercicios.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String descripcion;
    private String foto;
    private LocalDate fechaNac;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    // Con el join column se le especifica que en esta variable se va a hacer la unión entre las 2 tablas
    @ToString.Exclude
    // Para evitar la muerte
    private Usuario usuario;

}
