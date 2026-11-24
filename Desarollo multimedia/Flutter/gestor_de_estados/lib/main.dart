import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/providers/theme_provider.dart';
import 'package:gestor_de_estados/screens/home_screen.dart';
import 'package:provider/provider.dart';

// Con mateapp se puede generar bastante código de 1

// Se ponen los providers aquí arriba para que sea de las primeras cosas en cargar
void main() => runApp(MultiProvider(
  providers: [
    ChangeNotifierProvider(create: (context) => ContadorProvider()),
    ChangeNotifierProvider(create: (context) => ThemeProvider())
  ],
  child: const MyApp()));

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Con MultiProvider se pueden usar los providers creados
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Material App',
        home: HomeScreen(),
        theme: ThemeData.light(),
        darkTheme: ThemeData.dark(),
        themeMode: context.watch<ThemeProvider>().themeMode,
      );
  }
}