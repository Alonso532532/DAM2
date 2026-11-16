package estudio.paractica;

import estudio.paractica.modelo.Oferta;
import estudio.paractica.modelo.Producto;
import estudio.paractica.repositorios.OfertaRepositorio;
import estudio.paractica.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

//net start MySQL80
//select * from oferta; select * from producto;
//drop database estudio; create database estudio; use estudio;

@SpringBootApplication
public class ParacticaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParacticaApplication.class, args);
	}

	@Autowired
	ProductoRepositorio productoRepositorio;

	@Autowired
	OfertaRepositorio ofertaRepositorio;

	@Override
	public void run(String... args) throws Exception {
		// Creación de producto
		// Producto productoI = Producto.builder().nombre("producto1").precio(5.40).cant(20).build();
		// productoRepositorio.save(productoI);

		// Modificación de producto
//		Optional<Producto> productoOptional = productoRepositorio.findById(1L);
//
//		if (productoOptional.isPresent()){
//			Producto productoO = productoOptional.get();
//
//			productoO.setCant(productoO.getCant()-1);
//
//			productoRepositorio.save(productoO);
//		}

		Oferta ofertaI = Oferta.builder()
				.nombre("Black friday")
				.porcentaje(20.0)
				.inicio(LocalDateTime.now())
				.fin(LocalDateTime.of(2026, 12, 1, 12, 0))
				.build();

		Oferta ofertaII= Oferta.builder()
				.nombre("Rebajas de otoño")
				.porcentaje(15.0)
				.inicio(LocalDateTime.now())
				.fin(LocalDateTime.of(2026, 12, 13, 12, 0))
				.build();

		Producto productoI = Producto.builder()
				.nombre("producto con oferta")
				.precio(6.40)
				.cant(20)
				.build();

		productoI.addOferta(ofertaI);
		productoI.addOferta(ofertaII);

		productoRepositorio.save(productoI);

		//Optional<Producto> productoOptional = productoRepositorio.findById(1L);
//
		//if (productoOptional.isPresent()){
		//	Producto productoO = productoOptional.get();
		//	productoRepositorio.delete(productoO);
		//}


		//List<Producto> productos = productoRepositorio.findAll();
		//List<Oferta> ofertas = ofertaRepositorio.findAll();
//
		//productos.forEach(System.out::println);
//
		//ofertas.forEach(System.out::println);
	}
}
