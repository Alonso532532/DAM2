package mongo.demoSpringMongo;

import lombok.RequiredArgsConstructor;
import mongo.demoSpringMongo.modelos.Producto;
import mongo.demoSpringMongo.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoSpringMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringMongoApplication.class, args);
	}

	private final ProductoRepository productoRepository;

	@Override
	public void run(String... args) throws Exception {
		// Crear y guardar
//		Producto producto = Producto.builder().sku("BY31232313CA").nombre("Cosa").categoria("Cosas").precio(15.2).stock(12).build();
//		productoRepository.save(producto);

		// Seleccionar todo
//		List<Producto> productoList = productoRepository.findAll();
//		System.out.println(productoList);

		// Delete
		Producto producto = productoRepository.findById("6b0727202f292d7e130c4503").orElseThrow(()->new IllegalArgumentException("Iker"));
		System.out.println(producto);
		productoRepository.delete(producto);
	}
}
