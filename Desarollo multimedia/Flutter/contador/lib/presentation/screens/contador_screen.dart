import 'package:contador/presentation/widgets/boton_personalizado.dart';
import 'package:flutter/material.dart';
// Creo un widget para usarlo
// los widgets stateless son estaticos, los stateful son dinamicos, se pueden cambiar con la bombillica
class ContadorScreen extends StatefulWidget {
  const new({super.key});

  // Que una clase rengga "_" significa que es privada
  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}


class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ----- La bombillica carrea dart
      // ----- Añado una barra arriba
      appBar: AppBar(
        title: Text("Contador App"),
        centerTitle: true,
      ),

      // CUERPO
      body: Center(
        child: Column(
          // ----- Le digo que la columna los posicione en el centro
          // ----- Si se tiene que usar la clase otra vez para sacar algún valor solo hace falta un "."
          mainAxisAlignment: .center,
          children: [
            // ----- Se pueden añadir propiedades al widget 
            Text(
              contador.toString(), 
              style: TextStyle(
                fontSize: 160,
                fontWeight: .w100
              ),
            ),
            Text(
              "Clicks",
              style: TextStyle(
                fontSize: 45
              ),
              ),
          ],
          ),
      ),
      // ----- Botónes
      // ----- Con la bombillica se pueden extraer métodos  
      floatingActionButton: Column(
      mainAxisAlignment: .end,
      children: [
        BotonPersonalizado(icono: Icons.refresh_rounded,),
        SizedBox(height: 10,),        
        BotonPersonalizado(icono: Icons.plus_one,),        
        SizedBox(height: 10,),        
        BotonPersonalizado(icono: Icons.exposure_minus_1,),              
        ],
      )
    );
  }
}

