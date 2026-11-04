package org.iesch.ad.demoCarga.repositorios;

import org.iesch.ad.demoCarga.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
