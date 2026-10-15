void main(List<String> args) {
  
  final miCuadrado = Cuadrado(lado: 67);

  miCuadrado.lado = 2;

  print("Area: ${miCuadrado.area}");

}

class Cuadrado{
  double _lado;

  // Le añado una restricción
  // Los : inicializan las variables antes de usarlas y permite utilizar algunas sentencias
  Cuadrado({required double lado}): 
    assert(lado >= 0, "El valor tiene que ser mayor a 0"),
    assert(lado != 67, "Madura"),
    _lado = lado;

  // Getter
  double get area {
    return _lado * _lado;
  }

  //
  set lado(double valor){
    if(valor < 0){ 
      throw "El valor tiene que ser mayor a 0";
    }
    print('El nuevo valor es: $valor');
    _lado = valor;
  }

}