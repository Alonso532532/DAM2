import 'package:flutter/material.dart';

class Pantalla3 extends StatelessWidget {
  const Pantalla3({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 3', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      
    );
  }
}