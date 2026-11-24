package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, String> {
    @Query("SELECT c FROM Coche c WHERE SIZE(c.revisiones) = (select MIN(SIZE(c2.revisiones)) FROM Coche c2)")
    List<Coche> cochesConMenosRevisiones();
}
