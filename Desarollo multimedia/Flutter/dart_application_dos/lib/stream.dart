void main(List<String> args) {
  //var str = 
  emitirNumeros().listen((valor){print("Valor del evento: $valor");});
  //str.cancel();
}



Stream<int> emitirNumeros(){
  // hago un stream que consiste en un flujo continuo
  return Stream.periodic(Duration(milliseconds: 500), (valor){
    return valor;
  },).take(7);
}