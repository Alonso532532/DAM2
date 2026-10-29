package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
