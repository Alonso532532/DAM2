import 'package:flutter/material.dart';

const listaColores = <Color>[
  Colors.black,
  Colors.white,
  Colors.grey,
  Colors.red,
  Colors.green,
  Colors.blue
];

class AppTheme {
  final int colorSeleccionado;
  
  // Assert sirve para lanzar errores personalizados
  new({
    this.colorSeleccionado = 0
  }): assert( colorSeleccionado >= 0, 'El color seleccionado debe ser mayor que 0'),
      assert( colorSeleccionado < listaColores.length, 'El color seleccionado debe igual o menor que ${listaColores.length}');
  
  ThemeData getTheme() => ThemeData(
    useMaterial3: true,
    colorSchemeSeed: listaColores[colorSeleccionado], 

    appBarTheme: const AppBarTheme(
      centerTitle: true,
    ),

            // input decoration theme
    inputDecorationTheme: InputDecorationTheme(
      floatingLabelStyle: TextStyle(color: Colors.blue),
      enabledBorder: OutlineInputBorder(
        borderSide: BorderSide(color: Colors.blue),
        borderRadius: .only(
          bottomLeft: Radius.circular(10),
          topRight: Radius.circular(10),
        )
      ),
      focusedBorder: OutlineInputBorder(
        borderSide:  BorderSide(
          width: 3,
          color: Colors.blue,
        ),
        borderRadius: .only(
          bottomRight: Radius.circular(10),
          topLeft: Radius.circular(10),
        )
      )
    )
  );

  //Color primario

  static const Color primary =  Color.fromARGB(255, 175, 112, 76);
  static const Color secondary =  Color.fromARGB(255, 255, 139, 7);


  static final ThemeData darkTheme = ThemeData.dark().copyWith(
        useMaterial3: false,
        appBarTheme: AppBarTheme(
          backgroundColor: primary,
          elevation: 0,
        ),
        primaryColor: primary
  );

  // Tema de halloween

  static final ThemeData halloweenTheme = ThemeData.dark().copyWith(
        useMaterial3: false,
        appBarTheme: AppBarTheme(
          backgroundColor: const Color.fromARGB(255, 255, 112, 17),
          elevation: 0,
        ),
        iconTheme: IconThemeData(color: const Color.fromARGB(255, 255, 139, 7)),
        scaffoldBackgroundColor: const Color.fromARGB(255, 0, 0, 0),


  );

}