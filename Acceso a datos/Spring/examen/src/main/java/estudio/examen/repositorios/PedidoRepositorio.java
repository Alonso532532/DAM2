package estudio.examen.repositorios;

import estudio.examen.modelos.Cliente;
import estudio.examen.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
