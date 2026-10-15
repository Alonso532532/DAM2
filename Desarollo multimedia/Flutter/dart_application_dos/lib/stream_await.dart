void main(List<String> args) {
  //var str = 
  emitirNumeros().listen((valor){print("Valor del evento: $valor");});
  //str.cancel();
  // Aunque no haya terminado el stream el programa sigue
  print("Prueba");
}



Stream<int> emitirNumeros() async* {

  final valores = [6,7,8,9,10];

  for (int i in valores) {
    await Future.delayed(Duration(seconds: 1));
    yield i;
  }
}