package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.Modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepositorio extends JpaRepository<Orden, Long> {
}
