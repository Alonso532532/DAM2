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
      // Modo oscuro, ".light" para blanco
      theme: ThemeData.dark(),
      home: Scaffold(
        body: Center(
          child: Text('Hola a Dam 2')))
    );
  }

}