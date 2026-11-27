package estudio.examen.servicios;

import estudio.examen.modelos.Cliente;
import estudio.examen.modelos.Pedido;
import estudio.examen.modelos.Producto;
import estudio.examen.modelos.Proveedor;
import estudio.examen.repositorios.ClienteRepositorio;
import estudio.examen.repositorios.PedidoRepositorio;
import estudio.examen.repositorios.ProductoRepositorio;
import estudio.examen.repositorios.ProveedorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TiendaServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    public void crearCliente(String s) {
        clienteRepositorio.save(Cliente.builder().nombre(s).build());
    }

    public void modificarCliente(Long aLong, String s) {
        Cliente cliente = clienteRepositorio.findById(aLong).get();

        cliente.setNombre(s);

        clienteRepositorio.save(cliente);
    }

    @Transactional
    public void eliminarCliente(Long aLong) {
        Cliente cliente = clienteRepositorio.findById(aLong).get();

        cliente.getPedidos().forEach(p -> p.setCliente(null));

        clienteRepositorio.delete(cliente);
    }

    public void listarClientes() {
        clienteRepositorio.findAll().forEach(System.out::println);
    }

    public void crearPedido() {
        pedidoRepositorio.save(Pedido.builder().build());
    }

    public void modificarPedido(Long aLong, Double aDouble) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();
        pedido.setPrecioTotal(aDouble);
        pedidoRepositorio.save(pedido);
    }

    @Transactional
    public void eliminarPedido(Long aLong) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();

        if (pedido.getCliente() != null) pedido.getCliente().getPedidos().remove(pedido);


        pedidoRepositorio.delete(pedido);
    }

    public void listarPedidos() {
        pedidoRepositorio.findAll().forEach(System.out::println);
    }

    public void crearProducto(String s, String s1, Double aDouble) {
        productoRepositorio.save(Producto.builder().codigo(s).nombre(s1).precio(aDouble).build());
    }

    public void modificarProducto(String s, String s1, Double aDouble) {
        Producto producto = productoRepositorio.findById(s).get();

        producto.setNombre(s1);
        producto.setPrecio(aDouble);

        productoRepositorio.save(producto);
    }

    @Transactional
    public void eliminarProducto(String s) {
        Producto producto = productoRepositorio.findById(s).get();

        if (producto.getProveedor() != null) producto.getProveedor().setProducto(null);

        producto.getPedidos().forEach(p->p.getProductos().remove(producto));

        productoRepositorio.delete(producto);
    }

    public void listarProductos() {
        productoRepositorio.findAll().forEach(System.out::println);
    }

    public void crearProveedor(String s) {
        proveedorRepositorio.save(Proveedor.builder().nombre(s).build());
    }

    public void modificarProveedor(Long aLong, String s) {
        Proveedor proveedor = proveedorRepositorio.findById(aLong).get();

        proveedor.setNombre(s);

        proveedorRepositorio.save(proveedor);
    }

    public void listarProveedores() {
        proveedorRepositorio.findAll().forEach(System.out::println);
    }

    @Transactional
    public void eliminarProveedor(Long aLong) {
        Proveedor proveedor = proveedorRepositorio.findById(aLong).get();

        if (proveedor.getProducto() != null) proveedor.getProducto().setProveedor(null);

        proveedorRepositorio.delete(proveedor);
    }

    @Transactional
    public void quitarClienteDePedido(Long aLong) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();
        Cliente cliente = pedido.getCliente();

        pedido.setCliente(null);
        if (cliente != null) cliente.getPedidos().remove(pedido);
    }

    @Transactional
    public void quitarProductoDePedido(Long aLong, String s) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();
        Producto producto = productoRepositorio.findById(s).get();

        pedido.getProductos().remove(producto);
        producto.getPedidos().remove(pedido);
    }

    @Transactional
    public void quitarProveedorDeProducto(String s) {
        Producto producto = productoRepositorio.findById(s).get();
        Proveedor proveedor = producto.getProveedor();

        producto.setProveedor(null);
        proveedor.setProducto(null);
    }

    @Transactional
    public void asignarProveedorAProducto(String s, Long aLong) {
        Producto producto = productoRepositorio.findById(s).get();
        Proveedor proveedor = proveedorRepositorio.findById(aLong).get();

        if (producto.getProveedor()!=null) producto.getProveedor().setProducto(null);
        if (proveedor.getProducto()!=null) proveedor.getProducto().setProveedor(null);

        producto.setProveedor(proveedor);
        proveedor.setProducto(producto);
    }

    @Transactional
    public void anadirProductoAPedido(Long aLong, String s) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();
        Producto producto = productoRepositorio.findById(s).get();

        producto.getPedidos().add(pedido);
        pedido.getProductos().add(producto);
    }

    @Transactional
    public void asignarClienteAPedido(Long aLong, Long aLong1) {
        Pedido pedido = pedidoRepositorio.findById(aLong).get();
        Cliente cliente = clienteRepositorio.findById(aLong1).get();

        if (pedido.getCliente()!=null) pedido.getCliente().getPedidos().remove(pedido);

        pedido.setCliente(cliente);
        cliente.getPedidos().add(pedido);
    }

}
