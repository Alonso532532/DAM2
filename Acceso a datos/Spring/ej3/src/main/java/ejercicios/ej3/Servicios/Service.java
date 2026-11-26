package ejercicios.ej3.Servicios;

import ejercicios.ej3.Modelos.Asignatura;
import ejercicios.ej3.Modelos.Estudiante;
import ejercicios.ej3.Repositorios.EstudianteRepositorio;
import ejercicios.ej3.Repositorios.AsignaturaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    AsignaturaRepositorio asignaturaRepositorio;

    @Autowired
    EstudianteRepositorio estudianteRepositorio;

    @Transactional
    public void matricular(Long estudiante, Long asignatura) {
        Asignatura asig = asignaturaRepositorio.findById(asignatura).orElseThrow(()->new IllegalArgumentException("Id ["+asignatura+"] de asignatura no encontrado"));
        Estudiante est = estudianteRepositorio.findById(estudiante).orElseThrow(()->new IllegalArgumentException("Id ["+estudiante+"] de estudiante no encontrado"));

        asig.getEstudiantes().add(est);
        est.getAsignaturas().add(asig);

        estudianteRepositorio.save(est);
        asignaturaRepositorio.save(asig);
    }

    public void crearAsignatura(String s) {
        asignaturaRepositorio.save(Asignatura.builder().nombre(s).build());
    }

    public void crearEstudiante(String nombre, String s) {
        estudianteRepositorio.save(Estudiante.builder().nombre(nombre).email(s).build());
    }

    @Transactional
    public void desmatricular(Long estudiante, Long asignatura) {
        Asignatura asig = asignaturaRepositorio.findById(asignatura).orElseThrow(()->new IllegalArgumentException("Id ["+asignatura+"] de asignatura no encontrado"));
        Estudiante est = estudianteRepositorio.findById(estudiante).orElseThrow(()->new IllegalArgumentException("Id ["+estudiante+"] de estudiante no encontrado"));

        asig.getEstudiantes().remove(est);
        est.getAsignaturas().remove(asig);

        estudianteRepositorio.save(est);
        asignaturaRepositorio.save(asig);
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public Iterable<Asignatura> listarAsignaturas() {
        return asignaturaRepositorio.findAll();
    }

    @Transactional
    public void borrarEstudiante(long l) {
        Estudiante estudiante = estudianteRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("Id ["+l+"] de estudiante no encontrado"));

        // El list copy of está para evitar un fallo catastral

        for (Asignatura asignatura : List.copyOf(estudiante.getAsignaturas())) {
            desmatricular(estudiante.getId(), asignatura.getId());
        }
        estudianteRepositorio.delete(estudiante);
    }

    @Transactional
    public void borrarAsignatura(long l) {
        Asignatura asignatura = asignaturaRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("Id ["+l+"] de asignatura no encontrado"));

        for (Estudiante estudiante : List.copyOf(asignatura.getEstudiantes())) {
            desmatricular(estudiante.getId(), asignatura.getId());
        }

        asignaturaRepositorio.delete(asignatura);
    }


}
