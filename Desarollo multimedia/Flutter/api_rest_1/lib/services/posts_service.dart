// Esta clase se encargará de cargar los datos
import 'package:api_rest_1/models/post.dart';
import 'package:flutter/services.dart';
// Se importa esto con este alias ⬇️⬇️⬇️
import 'package:http/http.dart' as http;

class PostsService {

  // Metodo par ahacer la peticion, tiene que ser asincrono
  Future<List<Post>?> obtenerPosts() async{
    
    // Creo un cliente HTTP para hacer la peticion
    var cliente = http.Client();

    // Creo la dirección del api
    var uri = Uri.parse("https://jsonplaceholder.typicode.com/posts");

    // Envio la petición get y espero a la respuesta
    var response = await cliente.get(uri);

    // El codigo 200 quiere decir que la petición se ha realizado correctamente

    if (response.statusCode == 200){
      var json = response.body;

      // Transformo cada elemento json a dart
      return postFromJson(json);

    } else {
      return null;
    }
    
  }
}