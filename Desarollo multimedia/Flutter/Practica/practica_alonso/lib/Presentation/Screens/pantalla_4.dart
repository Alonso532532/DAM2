import 'package:flutter/material.dart';

class Pantalla4 extends StatelessWidget {
  const Pantalla4({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 4', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      
    );
  }
}