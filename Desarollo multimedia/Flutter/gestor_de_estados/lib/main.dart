import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/screens/home_screen.dart';
import 'package:provider/provider.dart';

// Con mateapp se puede generar bastante código de 1

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Con MultiProvider se pueden usar los providers creados
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (context) => ContadorProvider())
      ],
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Material App',
        home: HomeScreen()
      ),
    );
  }
}