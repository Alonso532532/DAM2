package org.iesch.ad.demoCarga.repositorios;

import org.iesch.ad.demoCarga.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
