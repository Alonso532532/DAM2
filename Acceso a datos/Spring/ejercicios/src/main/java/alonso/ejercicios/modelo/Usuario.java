package alonso.ejercicios.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    String contrasena;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    // mapped by quiere decir que la relación ya está echa en perfil, con la variable "usuario"
    // el cascade hace que no hayan perfiles sin usuarios
    private Perfil perfil;

    // Para que al asignarle un perfil al perfil también se le asigne el usuario
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
        if (perfil != null){
            perfil.setUsuario(this);
        }
    }
}
