// Este provider va a manejar el contador de la pag 2

import 'package:flutter/material.dart';

// ChangeNotifier sirve para dar notificaciónes a los widgets cuando su estado cambia
class ContadorProvider extends ChangeNotifier {

  // Si se quiere usar provider hay que poder leer el valor del estado de algo y modificarlo
  int _contador = 0;

  // Se tienen que hacer getters y setters para acceder a las variables
  int get contador => _contador;

  void incrementar(){
    _contador++;
    // Esto permite notificar de que se ha cambiado un valor para poder actualizar la app
    notifyListeners();
  }

  void decrementar(){
    _contador--;
    // Esto permite notificar de que se ha cambiado un valor para poder actualizar la app
    notifyListeners();
  }

}