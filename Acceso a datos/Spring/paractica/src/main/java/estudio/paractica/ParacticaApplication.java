package estudio.paractica;

import estudio.paractica.modelos.Oferta;
import estudio.paractica.modelos.Producto;
import estudio.paractica.repositorios.OfertaRepositorio;
import estudio.paractica.repositorios.ProductoRepositorio;
import estudio.paractica.servicios.TiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

//net start MySQL80
//select * from oferta; select * from producto;
//drop database estudio; create database estudio; use estudio;

@SpringBootApplication
public class ParacticaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ParacticaApplication.class, args);
	}

	@Autowired
	OfertaRepositorio ofertaRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	TiendaServicio tiendaServicio;

	@Override
	public void run(String... args) throws Exception {
		Producto producto1 = Producto.builder().nombre("Productico1").precio(21D).build();
		Producto producto2 = Producto.builder().nombre("Productico2").precio(60D).build();
		Oferta oferta = Oferta.builder().nombre("Oferta").porcentaje(10).build();
		ofertaRepositorio.save(oferta);

		producto1.setOferta(oferta);

		productoRepositorio.save(producto1);
		productoRepositorio.save(producto2);


		tiendaServicio.eliminar(oferta);

		tiendaServicio.mostrarDatos();
	}
}
