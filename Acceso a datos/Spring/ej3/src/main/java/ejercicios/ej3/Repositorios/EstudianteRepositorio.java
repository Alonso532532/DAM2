package ejercicios.ej3.Repositorios;

import ejercicios.ej3.Modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
