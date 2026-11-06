import 'package:flutter/material.dart';

class Pantalla2 extends StatelessWidget {
  const Pantalla2({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 2', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      
    );
  }
}