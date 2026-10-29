import 'package:flutter/material.dart';

class AppTheme {
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