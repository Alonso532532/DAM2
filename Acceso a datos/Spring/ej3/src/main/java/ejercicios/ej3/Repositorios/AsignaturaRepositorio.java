package ejercicios.ej3.Repositorios;

import ejercicios.ej3.Modelos.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepositorio extends JpaRepository<Asignatura, Long> {
}
