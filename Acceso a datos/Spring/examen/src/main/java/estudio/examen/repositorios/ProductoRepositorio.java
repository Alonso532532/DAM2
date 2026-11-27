package estudio.examen.repositorios;

import estudio.examen.modelos.Cliente;
import estudio.examen.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
}
