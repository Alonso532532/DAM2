void main(List<String> args) {
  print("Inicio del programa");
  
  // Hago que la función trabaje en segundo plano ya que devuelvo un "Future<String>"
  httpGet("http://www.google.es").then((value) {
    print(value);
  }).catchError((error)=> print(error));


  print("Final del programa");
}

Future<String> httpGet(String url){
  return Future.delayed(Duration(seconds: 2), () {
    throw "Error en la peticion";
  });
}