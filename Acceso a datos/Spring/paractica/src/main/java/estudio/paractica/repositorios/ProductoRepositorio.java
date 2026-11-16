package estudio.paractica.repositorios;

import estudio.paractica.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    // Se puede usar un atributo en la consulta ya sea con snake o camel case
    // Ej: findByHabitacionId o findByHabitacion_id

    @Query
    List<Producto> findByPrecioBetween(Double d1, Double d2);
    // Para buscar las palabras clave https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
