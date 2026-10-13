void main() {
  // hay que ponerle que va a ser <String, dynamic> porque <String, Object> no deja acceder a jsones anidados
  final Map<String, dynamic> pokemon = {
    'nombre': 'Ditto',
    'hp': 100,
    'isAlive': true,
    'sprites': {
      1: 'ditto/front.jpg',
      2: 'ditto/back.jpg' 
    }
  };
  
  print(pokemon);
  print('Nombre: ${pokemon['nombre']}');
  
  print('Nombre: ${pokemon['sprites'][2]}');
}