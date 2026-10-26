package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.Modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepositorio extends JpaRepository<Coche, Long> {
}
