// para poder usarel "await" hay que hacer el main "async"
void main(List<String> args) async{
  print("Inicio del programa");

  try{
    print(await httpGet("Esta URL"));
  } catch (er){
    print("Ha ocurrido un error: $er");
  }

  print("Final del programa");
}

//Función asincrona con "async"
Future<String> httpGet(String url) async {
  /*await Future.delayed(Duration(seconds: 2), () {
    //throw "Error en la peticion";
  });*/
  await Future.delayed(Duration(seconds: 3));
  // return "Respuesta";
  throw "Error Terrible";
}