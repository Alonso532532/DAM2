package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.Modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepositorio extends JpaRepository<Curso, Long> {

}
