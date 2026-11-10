import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SnackScreen extends StatelessWidget {
   
  const SnackScreen({super.key});

  void mostrarSnackBarPersonalizado(BuildContext context){
    // Elimino el snackbar actual para evitar que se repita muchas veces
    ScaffoldMessenger.of(context).clearSnackBars();
    final snackBar = SnackBar(
      content: Text("Hola ADAM"),
      duration: Duration(seconds: 4),
      backgroundColor: CupertinoColors.activeBlue,
      action: SnackBarAction(label: "Ok!", onPressed: (){},),
    );
    // Mostramos el snacbar
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("SmackBar"),
      ),

      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.remove_red_eye_outlined),
        onPressed: ()=>mostrarSnackBarPersonalizado(context), 
        label: Text("Mostrar Snackbar")),
    );
  }
}