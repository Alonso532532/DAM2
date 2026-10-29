import 'package:componentes/presentation/screens/buttons_screen.dart';
import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';
// Los imports de otras screens los e movido a el archivo "screens.dart" y con la bombillica donde da error lo permite importar
import 'presentation/screens.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      //home: ListView2Screen(),
      // Para asignar la ventana principal
      initialRoute: "home",
      // Para asignar varias ventanas
      routes: {
        "home"      :(context) => MenuScreen(),
        "listview1" :(context) => ListView1Screen(),
        "listview2" :(context) => ListView2Screen(),
        "alert"     :(context) => AlertScreen(),
        "card"      :(context) => CardScreen(),
        "buttons"   :(context) => ButtonsScreen(),
      },
      // Para Establecer una ruta por defecto si la ruta a la que va no existe
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => CardScreen(),),
      theme: AppTheme().getTheme(),
    );
  }
}