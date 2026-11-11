package alonso.ejercicios;

import alonso.ejercicios.Service.UsuarioService;
import alonso.ejercicios.modelo.Perfil;
import alonso.ejercicios.modelo.Usuario;
import alonso.ejercicios.repositorios.PerfilRepositorio;
import alonso.ejercicios.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;


// Para poder usar el método run hace falta implementar CommandLineRunner
@SpringBootApplication
public class EjerciciosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosApplication.class, args);
	}

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Autowired
	PerfilRepositorio perfilRepositorio;

	@Autowired
	UsuarioService usuarioService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("<"+"=".repeat(30)+">");
		// Crear
//		Perfil perfil = Perfil.builder().foto("/luisez/luis").descripcion("Hola ¡Estoy usando Whatsapp!").fechaNac(LocalDate.now()).build();
//
//		Usuario usuario = Usuario.builder().nombre("Luis").contrasena("Sor2425$").build();
//
//		usuario.setPerfil(perfil);
//
//		usuarioRepositorio.save(usuario);

		// Actualizar
//		Optional<Usuario> user = usuarioRepositorio.findById(1L);
//
//		if (user.isPresent()){
//			Usuario usuario = user.get();
//			System.out.println(usuario);
//
//			usuarioService.cambiarPerfil(usuario);
//
//			// Para cambiar el pefil de un usuario existente
//			// Le elimino el perfil antes de cambiarselo para que no se quede vacío y de error
////			usuario.setPerfil(null);
////			// Lo guardo sin perfil
////			usuarioRepositorio.save(usuario);
////			usuario.setPerfil(perfil);
////			// Lo guardo con perfil
////			usuarioRepositorio.save(usuario);
//		}

		// Para trabajar con excepciónes
		// Usuario user = usuarioRepositorio.findById(1L).orElseThrow();

		// Borrar
		// Largo
//		Optional<Usuario> user = usuarioRepositorio.findById(1L);
//
//		if (user.isPresent()) {
//			Usuario usuario = user.get();
//			usuarioRepositorio.delete(usuario);
//		}
		// Corto
		usuarioRepositorio.deleteById(1L);

		System.out.println("<"+"=".repeat(30)+">");

	}
}
