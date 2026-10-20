import 'package:flutter/material.dart';

class BotonPersonalizado extends StatelessWidget {

  final IconData icono;

  const new({
    super.key,
    required this.icono
  });

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(
    child: Icon(icono),
    backgroundColor: const Color.fromARGB(255, 255, 153, 0),
    onPressed: (){

      //print(contador);
      // "setState" hace que se actualize la página pero da fallo si está extaido en otra clase
      //setState(() {
      //  
      //});
    });
  }
}