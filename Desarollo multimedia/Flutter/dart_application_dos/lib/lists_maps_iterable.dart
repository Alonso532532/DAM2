void main(List<String> args) {
  final numeros = [1,3,4,5,7,1,5,3,8,7,1,6];

  print('Lista normal: ${numeros}');
  print('Lista tamaño: ${numeros.length}');
  print('Lista primer elemento: ${numeros[0]}');
  print('Lista al revés: ${numeros.reversed}');
  print('Lista esta vacía: ${numeros.isEmpty}');

  final numerosReversed = numeros.reversed;
  print('iterable: ${numerosReversed} <-- es iterable porque usa ()');
  print('Para volver a lista: ${numerosReversed.toList()}');
  print('Set: ${numerosReversed.toSet()}');

  // final numerosMasQue5 = numeros.where((a)=>a>5);
  final numerosMasQue5 = numeros.where((int num) {
    return num>5;
  });
  print('Numeros mayores que 5: ${numerosMasQue5} <-- es un iterable');

  //numeros.sort(((a, b) => a-b));
  //print('Lista esta vacía: ${numeros}');
}