import 'package:flutter/material.dart';

import '/screens.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      // Para asignar la ventana principal
      initialRoute: "login",
      // Para asignar varias ventanas
      routes: {
        "login" :(context) => LoginPage(),
        "home" :(context) => HomePage(),
      },
    );
  }
}
