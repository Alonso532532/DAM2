package alonso.ejercicios.Service;

import alonso.ejercicios.modelo.Perfil;
import alonso.ejercicios.modelo.Usuario;
import alonso.ejercicios.repositorios.PerfilRepositorio;
import alonso.ejercicios.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PerfilRepositorio perfilRepositorio;

    public void cambiarPerfil(Usuario usuario){

        // Actualizo los datos del perfil de un usuario

        Perfil perfil = usuario.getPerfil();

        perfil.setDescripcion("Hola ¡NO estoy usando Whatsapp!");
        perfil.setFoto("/Nuevo/Pasc");

        usuarioRepositorio.save(usuario);


    }
}
