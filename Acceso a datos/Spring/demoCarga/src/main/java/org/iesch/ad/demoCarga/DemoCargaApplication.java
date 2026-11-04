package org.iesch.ad.demoCarga;

import org.iesch.ad.demoCarga.repositorios.ClienteRepositorio;
import org.iesch.ad.demoCarga.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCargaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Autowired
	PedidoRepositorio pedidoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoCargaApplication.class, args);
	}

}
