package estudio.paractica.servicios;

import estudio.paractica.modelos.Oferta;
import estudio.paractica.modelos.Producto;
import estudio.paractica.repositorios.OfertaRepositorio;
import estudio.paractica.repositorios.ProductoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaServicio {

    @Autowired
    OfertaRepositorio ofertaRepositorio;
    @Autowired
    ProductoRepositorio productoRepositorio;

    @Transactional
    public void mostrarDatos(){
        System.out.println("<==================== PRODUCTOS ====================>");
        productoRepositorio.findAll().forEach(System.out::println);
        System.out.println("<==================== OFERTAS ====================>");
        ofertaRepositorio.findAll().forEach(System.out::println);
    }

    @Transactional
    public void eliminar(Object o){
        if (o.getClass() == Producto.class){
            Producto p = productoRepositorio.findById(((Producto) o).getId()).orElseThrow(() -> new IllegalArgumentException("Catastrofico"));

            if (p.getOferta()!=null){
                Oferta of = p.getOferta();
                of.setProductoOfertado(null);
                ofertaRepositorio.save(of);
            }

            productoRepositorio.delete(p);
        } else if (o.getClass() == Oferta.class){
            Oferta of = ofertaRepositorio.findById(((Oferta) o).getId()).orElseThrow(() -> new IllegalArgumentException("Terrible"));

            if (of.getProductoOfertado()!=null){
                Producto p = of.getProductoOfertado();
                p.setOferta(null);
                productoRepositorio.save(p);
            }

            ofertaRepositorio.delete(of);
        } else {
            throw new IllegalArgumentException("MAL");
        }
    }

}
