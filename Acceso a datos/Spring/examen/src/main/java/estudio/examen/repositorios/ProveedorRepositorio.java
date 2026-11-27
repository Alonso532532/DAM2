package estudio.examen.repositorios;

import estudio.examen.modelos.Cliente;
import estudio.examen.modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
}
