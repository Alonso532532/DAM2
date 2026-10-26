package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.Modelo.Coche;
import org.iesch.ad.demoSpring1.Modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.CocheRepositorio;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
//Si quiero que la clase use un .properties en el código con UTF-8
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8")
//Para usar un repositorio hay varias formas, una es con @RequiredArgsConstructor
//@RequiredArgsConstructor
public class DemoSpring1Application implements CommandLineRunner {

	// Para traer valores de un ".properties"
	@Value("${mi.app.nombre}")
	String nombre;

	@Value("${mi.app.version}")
	String version;

	@Value("${firma}")
	String firma;

	// Detecta automaticamente el bean que devuelve los datos
	@Autowired
	List<Persona> listaDePersonas;

	//  Para usar un repositorio hay varias formas, una es con @Autowired y que lo pille solo
	@Autowired
	PersonaRepositorio personaRepositorio;

	@Autowired
	CocheRepositorio cocheRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	/*Para usar un repositorio hay varias formas, una es crear un constructor
	PersonaRepositorio personaRepositorio;

	public DemoSpring1Application(PersonaRepositorio personaRepositorio) {
		this.personaRepositorio = personaRepositorio;
	}
	 */

	@Override
	public void run(String... args) throws Exception {

		/* ========= Con el builder de lombock

		Persona p1 = Persona.builder().nombre("Iker").apellidos("Leo").email("ilozanor@iesch.org").dni("12312312S").build();
		Persona p2 = Persona.builder().nombre("Albert").apellidos("Redbull").email("flutter@iesch.org").dni("3123123G").build();
		Persona p3 = Persona.builder().nombre("Pascual").apellidos("Pascualez").email("odoo@iesch.org").dni("59659693J").build();
		Persona p4 = Persona.builder().nombre("Jose").apellidos("Angelo").email("avions@iesch.org").dni("2425123U").build();


		List<Persona> listaPersonas = new ArrayList<>(Arrays.asList(p1,p2,p3,p4));

		//personaRepositorio.save(p1);

		personaRepositorio.saveAll(listaPersonas);
		*/
		// CRUD
		// Para añadir personas, hay que tener en cuenta que el id se calcula solo por eso es null
//		List<Persona> listaPersonas = new ArrayList<>(Arrays.asList(
//				new Persona(null,"Alonso", "Soriano", "1943245A", "Email@email.com"),
//				new Persona(null,"Pableras", "Hectroll", "23345345F", "Email@email.com"),
//				new Persona(null,"Stan", "Lozano", "52525G", "Email@email.com")
//		));
//
//		personaRepositorio.saveAll(listaPersonas);

//		Persona p = new Persona();
//
//		p.setNombre("Luis");
//		p.setApellidos("Albert");
//		p.setDni("2523343G");
//		p.setEmail("asda@dafa.com");
//
//		personaRepositorio.save(p);

		// ========= Para conseguir todas las personas mediante un repositorio
//		List<Persona> listaPersonasLectura = personaRepositorio.findAll();
//
//		listaPersonasLectura.forEach(a->{
//			System.out.println(a);
//		});

		// ========= Para buscar por id
//		Optional<Persona> personaEncontrada = personaRepositorio.findById(2L);

//		if (personaEncontrada.isPresent()){
//			Persona p = personaEncontrada.get();
//			System.out.println(p);
//		} else {
//			System.out.println("Persona no encontrada");
//		}

		// ========= Para modificar sus atributos en la BBDD

//		if (personaEncontrada.isPresent()){
//			personaEncontrada.get().setNombre("Pascual");
//			personaEncontrada.get().setApellidos("Perez");
//			// Y guardo los cambios, necesita un objeto de la clase del repositorio
//			personaRepositorio.save(personaEncontrada.get());
//		} else {
//			System.out.println("Persona no encontrada");
//		}

		// ========= Para borrarla

//		if (personaEncontrada.isPresent()){
//			personaRepositorio.delete(personaEncontrada.get());
//		} else {
//			System.out.println("Persona no encontrada");
//		}

		// ========= Se puede hacer un objeto temporal para trabajar con él

//		Persona personatmp = new Persona();
//		personatmp.setId(1L);
//		personaRepositorio.delete(personatmp);

//		System.out.println(nombre+" - "+version+" - "+firma);
//
//		System.out.println("Hola PASC");

//		System.out.println(version);
//		System.out.println(nombre);
//		System.out.println(firma);

//		Persona p = Persona.builder().id(1L).nombre("Alonso").apellidos("Soriano").build();
//
//		System.out.println(p);

//		listaDePersonas.forEach(System.out::println);

		// =========== Para ejecutar consultas echas con "@Query" o "@NativeQuery"
//		System.out.println("Por HQL");
//		List<Persona> resultadoDeConsulta = personaRepositorio.buscaTodasPersonas();
//		resultadoDeConsulta.forEach(System.out::println);

//		System.out.println("Por nativo");
//		List<Persona> resultadoDeConsulta2 = personaRepositorio.buscaTodasPersonasNative();
//		resultadoDeConsulta2.forEach(System.out::println);

		// ============== Para ejecutar consultas echas con el nombre del metodo
//		System.out.println("Personas que empiezan por L");
//		List<Persona> resultadoDeConsulta3 = personaRepositorio.findByNombreStartingWith('L');
//		resultadoDeConsulta3.forEach(System.out::println);

//		System.out.println("Personas que tengan A en el dni y sus apellidos tengan S");
//		List<Persona> resultadoDeConsulta4 = personaRepositorio.findByDniContainingAndApellidosContaining('A', "S");
//		resultadoDeConsulta4.forEach(System.out::println);

//		System.out.println("Personas que tengan 9 en el dni o no tengan email");
//		List<Persona> resultadoDeConsulta5 = personaRepositorio.findByDniContainingOrEmailNull('9');
//		resultadoDeConsulta5.forEach(System.out::println);

		// ========== Pruebas con clases relacionadas
		System.out.println("================ One to One ====================");
//		Persona p = new Persona();
//
//		p.setNombre("Crlos");
//		p.setApellidos("Casado");
//		p.setDni("1111111G");
//		p.setEmail("dasdasffff@daasdassfa.com");
//		// Es necesario un repositoio para el coche también
//		p.setCoche(new Coche(null, "Toyota", "Corola", "23425-PSP"));
//
//		personaRepositorio.save(p);
		Optional<Persona> personaConCoche = personaRepositorio.findById(11L);
		if (personaConCoche.isPresent()){
			Persona p = personaConCoche.get();
			System.out.println(p);
		}

		Optional<Coche> coche = cocheRepositorio.findById(1L);
		if (coche.isPresent()){
			Coche p = coche.get();
			System.out.println(p);
		}

	}
}
