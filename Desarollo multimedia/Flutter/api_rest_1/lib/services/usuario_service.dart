// Esta clase se encargará de cargar los datos
import 'package:api_rest_1/models/Usuario.dart';
import 'package:api_rest_1/models/post.dart';
import 'package:dio/dio.dart';
import 'package:flutter/services.dart';

class UserService {

  // Metodo par ahacer la peticion, tiene que ser asincrono
  Future<List<dynamic>> obtenerUsers() async{
    
    final dio = Dio();

    final respuesta = await dio.get("https://jsonplaceholder.typicode.com/users");

    if (respuesta.statusCode == 200){
      return respuesta.data;
    } else {
      throw Exception("Error al cargar los datos");
    }
    
  }
}