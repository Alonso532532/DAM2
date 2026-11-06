import 'package:flutter/material.dart';

class Pantalla5 extends StatelessWidget {
  const Pantalla5({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text('Pantalla 5', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      
    );
  }
}