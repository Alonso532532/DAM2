package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    List<Cliente> findDistinctByCochesColorIgnoreCase(String color);

    List<Cliente> findDistinctByCochesPrecioGreaterThan(BigDecimal precio);

//    @Query("SELECT c.nombre, c.nif, c.direccion FROM Cliente c WHERE SIZE(c.coches) = (select MAX(SIZE(c2.coches)) FROM Cliente c2)")
//    List<String> clientesConMasCoches();

    @Query("SELECT c.nombre, c.nif, c.direccion, SIZE(c.coches) FROM Cliente c ORDER BY SIZE(c.coches) DESC LIMIT 1")
    List<String> clientesConMasCoches();
}
