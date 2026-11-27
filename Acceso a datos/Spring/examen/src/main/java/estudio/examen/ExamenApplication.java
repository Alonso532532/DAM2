package estudio.examen;

import estudio.examen.repositorios.ClienteRepositorio;
import estudio.examen.repositorios.PedidoRepositorio;
import estudio.examen.repositorios.ProductoRepositorio;
import estudio.examen.repositorios.ProveedorRepositorio;
import estudio.examen.servicios.TiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExamenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@Autowired
	ProductoRepositorio productoRepositorio;

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Autowired
	PedidoRepositorio pedidoRepositorio;

	@Autowired
	ProveedorRepositorio proveedorRepositorio;

	@Autowired
	TiendaServicio servicio;

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public void run(String... args) {
		int opcion;
		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1. Clientes");
			System.out.println("2. Pedidos");
			System.out.println("3. Productos");
			System.out.println("4. Proveedores");
			System.out.println("5. Relaciones");
			System.out.println("0. Salir");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> menuClientes();
				case 2 -> menuPedidos();
				case 3 -> menuProductos();
				case 4 -> menuProveedores();
				case 5 -> menuRelaciones();
				case 0 -> System.out.println("Saliendo...");
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== CLIENTES =====================
	private void menuClientes() {
		int opcion;
		do {
			System.out.println("\n--- CLIENTES ---");
			System.out.println("1. Crear");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.crearCliente(leerTexto("Nombre: "));
				case 2 -> servicio.modificarCliente(
						leerLong("Id del cliente: "),
						leerTexto("Nuevo nombre: "));
				case 3 -> servicio.eliminarCliente(leerLong("Id del cliente: "));
				case 4 -> servicio.listarClientes();
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== PEDIDOS =====================
	private void menuPedidos() {
		int opcion;
		do {
			System.out.println("\n--- PEDIDOS ---");
			System.out.println("1. Crear");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.crearPedido();
				case 2 -> servicio.modificarPedido(
						leerLong("Id del pedido: "),
						leerDouble("Nuevo precio total: "));
				case 3 -> servicio.eliminarPedido(leerLong("Id del pedido: "));
				case 4 -> servicio.listarPedidos();
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== PRODUCTOS =====================
	private void menuProductos() {
		int opcion;
		do {
			System.out.println("\n--- PRODUCTOS ---");
			System.out.println("1. Crear");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.crearProducto(
						leerTexto("Código: "),
						leerTexto("Nombre: "),
						leerDouble("Precio: "));
				case 2 -> servicio.modificarProducto(
						leerTexto("Código del producto: "),
						leerTexto("Nuevo nombre: "),
						leerDouble("Nuevo precio: "));
				case 3 -> servicio.eliminarProducto(leerTexto("Código del producto: "));
				case 4 -> servicio.listarProductos();
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== PROVEEDORES =====================
	private void menuProveedores() {
		int opcion;
		do {
			System.out.println("\n--- PROVEEDORES ---");
			System.out.println("1. Crear");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.crearProveedor(leerTexto("Nombre: "));
				case 2 -> servicio.modificarProveedor(
						leerLong("Id del proveedor: "),
						leerTexto("Nuevo nombre: "));
				case 3 -> servicio.eliminarProveedor(leerLong("Id del proveedor: "));
				case 4 -> servicio.listarProveedores();
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== RELACIONES =====================
	private void menuRelaciones() {
		int opcion;
		do {
			System.out.println("\n--- RELACIONES ---");
			System.out.println("1. Asignar cliente a un pedido");
			System.out.println("2. Quitar cliente de un pedido");
			System.out.println("3. Añadir producto a un pedido");
			System.out.println("4. Quitar producto de un pedido");
			System.out.println("5. Asignar proveedor a un producto");
			System.out.println("6. Quitar proveedor de un producto");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.asignarClienteAPedido(
						leerLong("Id del pedido: "),
						leerLong("Id del cliente: "));
				case 2 -> servicio.quitarClienteDePedido(leerLong("Id del pedido: "));
				case 3 -> servicio.anadirProductoAPedido(
						leerLong("Id del pedido: "),
						leerTexto("Código del producto: "));
				case 4 -> servicio.quitarProductoDePedido(
						leerLong("Id del pedido: "),
						leerTexto("Código del producto: "));
				case 5 -> servicio.asignarProveedorAProducto(
						leerTexto("Código del producto: "),
						leerLong("Id del proveedor: "));
				case 6 -> servicio.quitarProveedorDeProducto(leerTexto("Código del producto: "));
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	private void consultas() {
		int opcion;
		do {
			System.out.println("\n--- RELACIONES ---");
			System.out.println("1. Pedidos de un cliente");
			System.out.println("2. ");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("0. Volver");
			opcion = leerEntero("Opción: ");

			switch (opcion) {
				case 1 -> servicio.asignarClienteAPedido(
						leerLong("Id del pedido: "),
						leerLong("Id del cliente: "));
				case 2 -> servicio.quitarClienteDePedido(leerLong("Id del pedido: "));
				case 3 -> servicio.anadirProductoAPedido(
						leerLong("Id del pedido: "),
						leerTexto("Código del producto: "));
				case 4 -> servicio.quitarProductoDePedido(
						leerLong("Id del pedido: "),
						leerTexto("Código del producto: "));
				case 5 -> servicio.asignarProveedorAProducto(
						leerTexto("Código del producto: "),
						leerLong("Id del proveedor: "));
				case 6 -> servicio.quitarProveedorDeProducto(leerTexto("Código del producto: "));
				case 0 -> { }
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}

	// ===================== LECTURA DE DATOS =====================
	private String leerTexto(String mensaje) {
		System.out.print(mensaje);
		return scanner.nextLine().trim();
	}

	private int leerEntero(String mensaje) {
		while (true) {
			try {
				return Integer.parseInt(leerTexto(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número entero válido");
			}
		}
	}

	private Long leerLong(String mensaje) {
		while (true) {
			try {
				return Long.parseLong(leerTexto(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Introduce un id válido");
			}
		}
	}

	private Double leerDouble(String mensaje) {
		while (true) {
			try {
				return Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número válido (ej. 19.95)");
			}
		}
	}
}
