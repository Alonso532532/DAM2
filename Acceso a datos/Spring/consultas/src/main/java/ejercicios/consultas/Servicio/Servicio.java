package ejercicios.consultas.Servicio;

import ejercicios.consultas.Modelos.Cliente;
import ejercicios.consultas.Modelos.Coche;
import ejercicios.consultas.Repositorios.ClienteRepositorio;
import ejercicios.consultas.Repositorios.CocheRepositorio;
import ejercicios.consultas.Repositorios.RevisionRepositorio;
import ejercicios.consultas.records.ClienteResumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    CocheRepositorio cocheRepositorio;

    @Autowired
    RevisionRepositorio revisionRepositorio;

    public List<Cliente> clientesPorColor(String color) {
        return clienteRepositorio.findDistinctByCochesColorIgnoreCase(color);
    }

    public List<Cliente> clientesPorPrecioMayorQue(BigDecimal precio) {
        return clienteRepositorio.findDistinctByCochesPrecioGreaterThan(precio);
    }

    public List<String> clientesConMasCoches() {
        return clienteRepositorio.clientesConMasCoches();
    }

    public List<Coche> cochesConMenosRevisiones() {
        return cocheRepositorio.cochesConMenosRevisiones();
    }

    public List<String> revisionesPorCoche() {
        return cocheRepositorio.infoCoches();
    }

    public Optional<Cliente> clientePorMatricula(String matricula) {
        return cocheRepositorio.clientePropietario(matricula);
    }

    public Optional<Cliente> clientePorCodigoRevision(String codigo) {
        return revisionRepositorio.clientePropietarioRevision(codigo);
    }

    public Optional<ClienteResumen> resumenPorCodigoRevision(String codigo) {
        return revisionRepositorio.clientePropietarioRevisionInfo(codigo);
    }
}
