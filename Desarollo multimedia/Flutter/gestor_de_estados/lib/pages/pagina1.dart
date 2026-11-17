import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:provider/provider.dart';

class Pagina1 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      body: Column(
        children: [
          Center(child: Text(
            // Saco el valor del contador
            context.watch<ContadorProvider>().contador.toString(), 
            style: TextStyle(fontSize: 120),)),
           ElevatedButton(
              // Utilizo una función
              onPressed: context.read<ContadorProvider>().incrementar,
              child: Text("Incrementar"),
          ),
          ElevatedButton(
              // Utilizo una función
              onPressed: context.read<ContadorProvider>().decrementar,
              child: Text("Decrementar"),
          ),
        ],
      ),
    );
  }
}