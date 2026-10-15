import 'package:contador/presentation/screens/contador_screen.dart';
import 'package:flutter/material.dart';

void main(List<String> args) {
  runApp(MyApp());
  print("Hola Alonso Soriano Maicas");
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Para quitar el simbolo de "debug"
      debugShowCheckedModeBanner: false,
      // Tema de la app, ".light" para blanco
      theme: ThemeData.dark(
        useMaterial3: true
      ),
      home: ContadorScreen()
    );
  }

}