package org.iesch.ad.demoCarga.servicios;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoCarga.modelo.Cliente;
import org.iesch.ad.demoCarga.repositorios.ClienteRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// Es obligatorio hacer un servicio por cada clase y se pueden hacer más si es necesario
@Service // Logica de negocio
@RequiredArgsConstructor
public class ClienteService {

    // otra forma de traer Repositorios y servicios
    private final ClienteRepositorio clienteRepositorio;

    // Tiene que ser el logger de slf4j
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    // Es necesario que tenga transactional si la relación el lazy para que la conexión no se abra y se cierre en esta línea solo:
    // Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
    // permitiendo sacar los datos necesarios
    @Transactional
    public void mostrarDatos(long id) {
        logger.trace("enrada en mostrarDatos");
        logger.debug("id "+id);

        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);

        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getId());
            System.out.println(cliente);
            System.out.println("-".repeat(20));
            System.out.println(cliente.getPedidos().size());
        }else System.out.println("No existe el id "+id);
        logger.trace("Se sale de mostrarDatos");
    }

    @Transactional
    public void mostrarTodos() {
        List<Cliente> clienteList = clienteRepositorio.findAll();
        System.out.println(clienteList.size());
        // Esto Hace más consultas de las que necesita
        // hace la cantidad de elementos de la tabla +1
        // se le conoce como el problema de las n+1 consultas
        for (Cliente c : clienteList){
            System.out.println("Cliente: "+c.getId()+" - "+c.getPedidos().size());
        }
    }

    public void arreglaN1(){
        // Al usar una consulta personalizada se hace solo en 1
        // Estas consultas se hacen en el repositorio
        List<Cliente> clienteList = clienteRepositorio.findAllConPedidios();
        for (Cliente c : clienteList){
            System.out.println("Cliente: "+c.getId()+" - "+c.getPedidos().size());
        }
    }
}
