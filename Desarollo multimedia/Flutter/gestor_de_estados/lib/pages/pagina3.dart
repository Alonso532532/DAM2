import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/providers/theme_provider.dart';
import 'package:provider/provider.dart';

class Pagina3 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(child: Column(
        mainAxisAlignment: .center,
        children: [
          Text("El contador de la pag 1 marca:"),
          Text(context.watch<ContadorProvider>().contador.toString(), style: TextStyle(fontSize: 120),),
          SizedBox(height: 30,),
          ElevatedButton(
            // Utilizo una función
            onPressed: context.watch<ThemeProvider>().cambiarTheme,
            child: Text("Cambiar Light/dark"),
          ),
        ],
      ),
    ));
  }
}