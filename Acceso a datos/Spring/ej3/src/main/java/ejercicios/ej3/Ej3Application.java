package ejercicios.ej3;

import ejercicios.ej3.Repositorios.EstudianteRepositorio;
import ejercicios.ej3.Repositorios.AsignaturaRepositorio;
import ejercicios.ej3.Servicios.Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Ej3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej3Application.class, args);
	}

	@Autowired
	Service service;

	@Autowired
	AsignaturaRepositorio asignaturaRepositorio;

	@Autowired
	EstudianteRepositorio estudianteRepositorio;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nCURSOS: 1 Crear estudiante | 2 Crear asignatura | 3 Matricular | 4 Desmatricular | 5 Listar | 6 Borrar estudiante | 7 Borrar asignatura | 0 Salir");
			String opcion = in.nextLine().trim();
			if (opcion.equals("0")) return;
			try {
				switch (opcion) {
					case "1" -> { System.out.print("Nombre: "); String nombre = in.nextLine(); System.out.print("Email: "); service.crearEstudiante(nombre, in.nextLine()); }
					case "2" -> { System.out.print("Nombre de asignatura: "); service.crearAsignatura(in.nextLine()); }
					case "3", "4" -> {
						System.out.print("Id estudiante: "); Long estudiante = Long.parseLong(in.nextLine());
						System.out.print("Id asignatura: "); Long asignatura = Long.parseLong(in.nextLine());
						if (opcion.equals("3")) service.matricular(estudiante, asignatura); else service.desmatricular(estudiante, asignatura);
					}
					case "5" -> {
						service.listarEstudiantes().forEach(e -> {
							System.out.printf("Estudiante %d: %s (%s)%n", e.getId(), e.getNombre(), e.getEmail());
							e.getAsignaturas().forEach(a -> System.out.printf("  Asignatura %d: %s%n", a.getId(), a.getNombre()));
						});
						service.listarAsignaturas().forEach(a -> System.out.printf("Asignatura %d: %s (%d estudiantes)%n", a.getId(), a.getNombre(), a.getEstudiantes().size()));
					}
					case "6" -> { System.out.print("Id estudiante: "); service.borrarEstudiante(Long.parseLong(in.nextLine())); }
					case "7" -> { System.out.print("Id asignatura: "); service.borrarAsignatura(Long.parseLong(in.nextLine())); }
					default -> System.out.println("Opción no válida.");
				}
			} catch (IllegalArgumentException | IllegalStateException e) {
				System.out.println("No se pudo completar la operación: " + e.getMessage());
			}
		}
	}
}
