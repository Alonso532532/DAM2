package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.Modelo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, Long> {

}
