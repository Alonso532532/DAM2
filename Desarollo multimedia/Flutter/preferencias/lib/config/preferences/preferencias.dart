// https://pub.dev/packages/shared_preferences/install el paquete que me he instalado
import 'package:shared_preferences/shared_preferences.dart';

class Preferencias {
  static late SharedPreferences _preferencias;

  // Aquí estarán las propiedades grlobales que voy a manejar en la app
  static bool _ubicacion = true;
  static bool _camara = true;
  static bool _tema_oscuro = false;
  static String _nombre = "";

  static Future init() async {
    _preferencias = await SharedPreferences.getInstance();
  }

  // Para acceder a estos creo los metodos necesarios
  static get nombre => _preferencias.getString("nombre") ?? _nombre;
  static get ubicacion => _preferencias.getBool("ubicacion") ?? _ubicacion;
  static get camara => _preferencias.getBool("camara") ?? _camara;
  static get tema_oscuro => _preferencias.getBool("tema_oscuro") ?? _tema_oscuro;

  static set nombre(String nombre){
    _nombre = nombre;
    _preferencias.setString("nombre", nombre);
  }

  static set ubicacion(bool ubicacion){
    _ubicacion = ubicacion;
    _preferencias.setBool("ubicacion", ubicacion);
  }

  static set camara(bool camara){
    _camara = camara;
    _preferencias.setBool("camara", camara);
  }

  static set tema_oscuro(bool tema_oscuro){
    _tema_oscuro = tema_oscuro;
    _preferencias.setBool("tema_oscuro", tema_oscuro);
  }
  
}