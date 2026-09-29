package Apuntes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Apuntes {
    static void main() {

        //stream();

        regex();

    }

    static void regex(){
        String cad = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin leo nisl, aliquam ut nisl vel, " +
                "rutrum tincidunt quam. Proin purus quam, euismod eu quam vel, efficitur rhoncus massa. Nam sit amet " +
                "gravida sapien. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus." +
                " Integer tristique lobortis lacus, nec auctor mi rhoncus ut. Vestibulum nec elit vitae lorem vulputate " +
                "ornare. Donec porta tincidunt tellus, quis porta massa sagittis eu. Cras viverra nisl a massa feugiat, " +
                "et lobortis mi rutrum. Vestibulum rutrum ex justo, efficitur posuere augue tempus at. Morbi pellentesque " +
                "lectus felis, eget tincidunt libero blandit ac. Suspendisse interdum, justo vel lobortis aliquet, nunc lorem " +
                "euismod eros, ut imperdiet ligula eros nec lectus. Cras sed cursus leo, ac consequat ante. Ut quis quam odio. " +
                "Vestibulum at efficitur felis. Donec nunc urna, viverra et condimentum malesuada, gravida in lectus. Sed nec " +
                "turpis lacus.";

        List<String> lista = new ArrayList<String>(List.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non dapibus diam, sed rhoncus leo. In nec elit semper, ullamcorper risus et, mollis lacus. Vestibulum quis tellus eget nisi imperdiet convallis. Praesent et massa augue. Morbi faucibus urna in felis finibus, interdum varius metus iaculis. Nam gravida turpis ut nibh molestie rhoncus. Vivamus scelerisque libero nisl, et ultrices massa efficitur ac. Phasellus efficitur magna in metus consequat, sed molestie arcu venenatis. Maecenas volutpat sodales orci a molestie. Integer vitae pulvinar justo, dictum pulvinar massa. In hendrerit luctus libero, nec ultrices diam consequat et.".split(" ")));

        System.out.println("\n\n==== Simples ====");
        System.out.println("\n---- Palabras que empiezan por i o r ----\n");
        Matcher matcher = Pattern.compile("\\b[ir]\\w*").matcher(cad);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        System.out.println("\n---- Primera palabra que empiece por c ----\n");
        matcher = Pattern.compile("c[a-zA-Z]*").matcher(cad);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("\n---- Palabras con longitud de 11 ----\n");
        matcher = Pattern.compile("\\b[a-zA-Z]{11}\\b").matcher(cad);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("\n\n==== Look ahead ====\n\n");

        System.out.println("---- Palabras con longitud de 11 y con una p ----\n");
        System.out.println("< El look ahead va a buscar mientras la condición \"[a-zA-Z]p\"se cumpla, en este caso si hay de 0 a 10 letras y una p se cumplirá >\n");
        matcher = Pattern.compile("(?=[a-zA-Z]*p)\\b[a-zA-Z]{11}\\b").matcher(cad);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("\n---- Contraseña con letra mayuscula, carácter especial y de 5 a 10 caracteres ----\n");
        matcher = Pattern.compile("(?=.*[A-Z])(?=.*[?¿=@%€!¡]).{5,10}").matcher("2123A%!");
        if (matcher.matches()) {
            System.out.println(matcher.group());
        }

        System.out.println("\n\n==== Complejos ====\n\n");

        System.out.println("---- Ip ----\n");
        matcher = Pattern.compile("((25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9]).){3}(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])").matcher("123.212.4.212");

        System.out.println(matcher.matches() ? "Válida "+matcher.group() : "Inválida");


    }

    static void stream(){
        List<Producto> lista = new ArrayList<>();

        lista.add(new Producto("Camiseta básica", 12.99, "Ropa", 0.10));
        lista.add(new Producto("Pantalón vaquero", 34.50, "Ropa", 0.0));
        lista.add(new Producto("Zapatillas running", 59.99, "Calzado", 0.20));
        lista.add(new Producto("Chaqueta impermeable", 79.90, "Ropa", 0.15));
        lista.add(new Producto("Auriculares bluetooth", 45.00, "Electrónica", 0.05));
        lista.add(new Producto("Teclado mecánico", 89.99, "Electrónica", 0.0));
        lista.add(new Producto("Ratón inalámbrico", 19.99, "Electrónica", 0.10));
        lista.add(new Producto("Monitor 24 pulgadas", 149.99, "Electrónica", 0.25));
        lista.add(new Producto("Silla de oficina", 120.00, "Muebles", 0.0));
        lista.add(new Producto("Mesa de escritorio", 95.50, "Muebles", 0.10));
        lista.add(new Producto("Lámpara LED", 22.30, "Muebles", 0.0));
        lista.add(new Producto("Mochila urbana", 39.99, "Accesorios", 0.15));
        lista.add(new Producto("Reloj deportivo", 65.00, "Accesorios", 0.0));
        lista.add(new Producto("Gafas de sol", 25.00, "Accesorios", 0.30));
        lista.add(new Producto("Botella térmica", 15.99, "Accesorios", 0.0));
        lista.add(new Producto("Balón de fútbol", 18.50, "Deporte", 0.0));
        lista.add(new Producto("Mancuernas 5kg", 29.99, "Deporte", 0.10));
        lista.add(new Producto("Esterilla de yoga", 14.99, "Deporte", 0.0));
        lista.add(new Producto("Bicicleta estática", 199.99, "Deporte", 0.20));
        lista.add(new Producto("Cuerda para saltar", 8.99, "Deporte", 0.0));

        System.out.println("\n\n==== Valores ====");
        System.out.println("\n---- COUNT ----\n");
        System.out.println(lista.stream().count());

        System.out.println("\n---- MAX/MIN ----\n");
        System.out.println(lista.stream().max(Comparator.comparing(Producto::getPrecio)));

        // Hago que solo me muestre 2 decimales
        System.out.println("\n---- AVG ----\n");
        System.out.println(Double.valueOf(Math.round(lista.stream().mapToDouble(Producto::getPrecio).average().getAsDouble()*100))/100);

        System.out.println("\n\n==== Valores con groupingBy ==== (Si se quiere de un tipo en especifico se hace con filter)\n\n");
        System.out.println("---- COUNT ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting())));

        System.out.println("---- MAX/MIN ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.maxBy(Comparator.comparing(Producto::getPrecio)))));

        System.out.println("---- AVG ----");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Producto::getCategoria, Collectors.averagingDouble(Producto::getPrecio))));

        System.out.println("\n\n==== Ordenar ====\n\n");
        System.out.println("\n---- Normal ---- (Por ptecio)\n");
        lista.stream().sorted(Comparator.comparing(Producto::getPrecio)).forEach(System.out::println);

        System.out.println("\n---- Con comparable ---- (Por precio total)\n");
        lista.stream().sorted().forEach(System.out::println);

        System.out.println("\n---- Con comparator ---- (Por oferta y si son iguales por nombre)\n");
        lista.stream().sorted(new comparadorPorOferta()).forEach(System.out::println);
    }
}

class comparadorPorOferta implements Comparator<Producto>{
    @Override
    public int compare(Producto o1, Producto o2) {
        double dif = o1.oferta-o2.oferta;
        if (dif!=0){
            return dif>0?1:-1;
        } else {
            return o1.getNombre().compareTo(o2.nombre);
        }
    }
}


class Producto implements Comparable<Producto>{
    String nombre;
    Double precio;
    String categoria;
    Double oferta;

    public Producto(String nombre, Double precio, String categoria, Double oferta) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.oferta = oferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getOferta() {
        return oferta;
    }

    public void setOferta(Double oferta) {
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "(Precio total="+(precio-precio*oferta)+") Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", oferta=" + oferta +
                '}';
    }

    // Comparable sirve para implementar este método
    // Aquí se compara el objeto actual con otro, si devuelve positivo
    // Si el precio con la oferta es mayor que el del otro será positivo y se pondrá después
    @Override
    public int compareTo(Producto o) {
        double dif = (this.precio-this.oferta*this.precio)-(o.precio-o.oferta*o.precio);
        if (dif>0){
            return 1;
        } else {
            return dif==0?0:-1;
        }
    }
}
