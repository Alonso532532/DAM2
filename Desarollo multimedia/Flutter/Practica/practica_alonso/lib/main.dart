import 'package:flutter/material.dart';
import 'package:practica_alonso/Presentation/screens.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const Scaffold(body: Center(child: Text('Hello World!'))),
      initialRoute: "p1",
      routes: {
        "p1":(context) => Pantalla1(),
        "p2":(context) => Pantalla2(),
        "p3":(context) => Pantalla3(),
        "p4":(context) => Pantalla4(),
        "p5":(context) => Pantalla5(),
      },
    );
  }
}
