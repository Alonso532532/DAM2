void main(List<String> args) {
  final hecproll = Heroe(nombre: "Hector Criado Gonzalez", poder: "Crear java, kotlin entre otros");
 
  print(hecproll.nombre);
  print(hecproll.poder);
  print(hecproll.toString());
}

// Creo una clase con un atibuto requerido y otro ocional con valor por defecto
class Heroe {
  String nombre;
  String poder;

  Heroe({
    required this.nombre,
    this.poder = 'Sin poder'
  });

  String toString(){
    return 'Metodo to string';
  }
}