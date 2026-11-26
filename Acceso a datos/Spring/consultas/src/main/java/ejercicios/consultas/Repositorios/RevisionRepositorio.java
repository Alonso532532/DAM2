package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Cliente;
import ejercicios.consultas.Modelos.Revision;
import ejercicios.consultas.records.ClienteResumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RevisionRepositorio extends JpaRepository<Revision, String> {

    @Query("SELECT c.cliente_id FROM Coche c WHERE c = (SELECT r.coche_id FROM Revision r where r.codigo = :codigo)")
    Optional<Cliente> clientePropietarioRevision(@Param("codigo") String codigo);

//    @Query("SELECT c.cliente_id, COUNT(c.matricula) as totalCoches, SUM(c.precio) as precioTotal FROM Coche c WHERE c = (SELECT r.coche_id FROM Revision r where r.codigo = :codigo) GROUP BY c.cliente_id")
//    Optional<String> clientePropietarioRevisionInfo(@Param("codigo") String codigo);


//    @Query("SELECT cl.id, cl.nif, cl.nombre, cl.direccion, cl.ciudad, cl.telefono, COUNT(c), SUM(c.precio) FROM Cliente cl JOIN cl.coches c WHERE cl.id = (SELECT r.coche_id.cliente_id.id FROM Revision r WHERE r.codigo = :codigo) GROUP BY cl.id")
//    Optional<String> clientePropietarioRevisionInfo(@Param("codigo") String codigo);

    @Query("SELECT new ejercicios.consultas.records.ClienteResumen(cl, COUNT(c), SUM(c.precio)) FROM Cliente cl JOIN cl.coches c WHERE cl.id = (SELECT r.coche_id.cliente_id.id FROM Revision r WHERE r.codigo = :codigo) GROUP BY cl.id")
    Optional<ClienteResumen> clientePropietarioRevisionInfo(@Param("codigo") String codigo);

}
