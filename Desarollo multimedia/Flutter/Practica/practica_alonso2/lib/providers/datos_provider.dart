import 'package:flutter/material.dart';

class DatosProvider extends ChangeNotifier {
  
  String email = "";
  String contrasena = "";

  String get getEmail => email;
  String get getContrasena => contrasena;

  void setEmail(String email){
    this.email = email;
  }

  void setContrasena(String contrasena){
    this.contrasena = contrasena;
  }

}